package com.rest.gestSchool.gestSchoolRest.web.dto.response.classe;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClasseListeDto {
    private Long id;
    private String libelle;
    private String attacher;
    private String filiere;
    private String niveau;
    private String anneeScolaire;


    public static ClasseListeDto toDto(Classe classe) {
        return ClasseListeDto.builder()
                .id(classe.getId())
                .libelle(classe.getLibelle())
                .attacher(classe.getAttacher().getNomComplet()+' '+classe.getAttacher().getTelephone())
                .filiere(classe.getFiliere().getLibelle())
                .niveau(classe.getNiveau().getLibelle())
                .anneeScolaire(classe.getAnneeScolaire().getLibelle())
                .build();
    }
}
