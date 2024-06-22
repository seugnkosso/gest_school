package com.rest.gestSchool.gestSchoolRest.web.dto.response.etudiant;

import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtudiantListDto {
    private Long id;
    private String telephone;
    private String matricule;
    private String nomComplet;

    public static EtudiantListDto toDto(Etudiant etudiant) {
        return EtudiantListDto.builder()
                .id(etudiant.getId())
                .telephone(etudiant.getTelephone())
                .matricule(etudiant.getMatricule())
                .nomComplet(etudiant.getNomComplet())
                .build();
    }
}
