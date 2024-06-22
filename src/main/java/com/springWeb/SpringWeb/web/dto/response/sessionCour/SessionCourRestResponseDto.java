package com.springWeb.SpringWeb.web.dto.response.sessionCour;

import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionCourRestResponseDto {
    private Long id;
    private String date;
    private String salle;
    private String module;
    private String etat;
    private Boolean isValider;

    public static SessionCourRestResponseDto toDto(SessionCour sessionCour) {
        return SessionCourRestResponseDto.builder()
                .id(sessionCour.getId())
                .etat(sessionCour.getEtat())
                .date(sessionCour.getDate().toString()+" | "+sessionCour.getHeureDebut().toString()+" | "+sessionCour.getHeureFin().toString())
                .isValider(sessionCour.getIsValider())
                .module(sessionCour.getCour().getModule().getLibelle())
                .salle(sessionCour.getSalle() != null ? sessionCour.getSalle().getLibelle() : "none")
                .build();
    }
}
