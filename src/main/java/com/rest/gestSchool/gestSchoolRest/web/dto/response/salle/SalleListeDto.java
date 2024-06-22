package com.rest.gestSchool.gestSchoolRest.web.dto.response.salle;

import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalleListeDto {
    private Long id;
    private String libelle;
    private Long nbrPlace;

    public static SalleListeDto toDto(Salle salle) {
        return SalleListeDto.builder()
                .id(salle.getId())
                .libelle(salle.getLibelle()+" "+salle.getNumero())
                .nbrPlace(salle.getNbrPlace())
                .build();
    }
}
