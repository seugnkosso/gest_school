package com.spring_GestSchool.spring_flutter.mobile.dto.response.sessionCour;

import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionCourRestResponseDto {
    private Long id;
    private String date;
    private String heureDebutFin;
    private String salle;
    private String etat;
    private boolean start;


    public static SessionCourRestResponseDto toDto(SessionCour sessionCour) {
        return SessionCourRestResponseDto.builder()
                .id(sessionCour.getId())
                .date(sessionCour.getDate().toString())
                .etat(sessionCour.getEtat() != null ? sessionCour.getEtat() : "" )
                .heureDebutFin(sessionCour.getHeureDebut().toString()+" "+sessionCour.getHeureFin().toString())
                .salle(sessionCour.getSalle() != null ? sessionCour.getSalle().getLibelle() : "none")
                .start(getIsStart(sessionCour.getDate(),sessionCour.getHeureDebut(),sessionCour.getHeureFin()))
                .build();
    }

    private static boolean getIsStart(Date date,Date heureDebut, Date heureFin){
        SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date heureActuel = new Date();
        Date dateActuel = new Date();
        try {
            date=formatDate.parse(date.toString());
            dateActuel=formatDate.parse(formatDate.format(dateActuel));
            heureDebut = formatHeure.parse(heureDebut.toString());
            heureFin = formatHeure.parse(heureFin.toString());
            heureActuel = formatHeure.parse(formatHeure.format(heureActuel));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(dateActuel.equals(date)){
            if (heureActuel.after(heureDebut) && heureActuel.before(heureFin)) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
