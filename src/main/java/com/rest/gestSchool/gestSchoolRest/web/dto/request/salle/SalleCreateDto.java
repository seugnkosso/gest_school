package com.rest.gestSchool.gestSchoolRest.web.dto.request.salle;

import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalleCreateDto {
    private Long id;
    private String libelle;
    private Long numero;
    private Long nbrPlace;

    public static SalleCreateDto toDto(Salle salle) {
        return SalleCreateDto.builder()
                .id(salle.getId())
                .libelle(salle.getLibelle()+" "+salle.getNumero())
                .nbrPlace(salle.getNbrPlace())
                .build();
    }
}
