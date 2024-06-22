package com.rest.gestSchool.gestSchoolRest.web.dto.request.classe;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClasseCreateRequestDto {
    private String libelle;
    private String searchAttacher;
    private Long attacher;
    private String searchFiliere;
    private Long filiere;
    private String searchNiveau;
    private Long niveau;
    private String searchAnnee;
    private Long anneeScolaire;
}
