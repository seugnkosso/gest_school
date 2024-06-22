package com.rest.gestSchool.gestSchoolRest.web.dto.response.sessionCour;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public static SessionCourRestResponseDto toDto(SessionCour sessionCour) {
        return SessionCourRestResponseDto.builder()
                .id(sessionCour.getId())
                .date(sessionCour.getDate().toString())
                .etat(sessionCour.getEtat())
                .heureDebutFin(sessionCour.getHeureDebut().toString()+" "+sessionCour.getHeureFin().toString())
                .salle(sessionCour.getSalle() != null ? sessionCour.getSalle().getLibelle() : "none")
                .build();
    }
}
