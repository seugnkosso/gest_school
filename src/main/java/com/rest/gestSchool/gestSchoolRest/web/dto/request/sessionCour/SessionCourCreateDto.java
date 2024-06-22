package com.rest.gestSchool.gestSchoolRest.web.dto.request.sessionCour;

import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionCourCreateDto {
    private String date;
    private String heureDebut;
    private String heureFin;
    private String searchSalle;
    private Long salle;
    private Long cour;
    private String etat;
}
