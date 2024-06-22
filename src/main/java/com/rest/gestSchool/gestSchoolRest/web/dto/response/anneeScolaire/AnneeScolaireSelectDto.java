package com.rest.gestSchool.gestSchoolRest.web.dto.response.anneeScolaire;

import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnneeScolaireSelectDto {
    private Long id;
    private String libelle;

    public static AnneeScolaireSelectDto toDto(AnneeScollaire anneeScollaire) {
        return AnneeScolaireSelectDto.builder()
                .id(anneeScollaire.getId())
                .libelle(anneeScollaire.getLibelle())
                .build();
    }
}
