package com.rest.gestSchool.gestSchoolRest.web.dto.request.inscription;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.etudiant.EtudiantCreateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscriptionCreateDto {
    private EtudiantCreateDto etudiant;
    private String searchAnnee;
    private Long anneeScolaire;
    private String searchClasse;
    private Long classe;
}
