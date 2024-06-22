package com.rest.gestSchool.gestSchoolRest.web.dto.response.niveau;

import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NiveauSelectDto {
    private Long id;
    private String libelle;

    public static NiveauSelectDto toDto(Niveau niveau) {
        return NiveauSelectDto.builder()
                .id(niveau.getId())
                .libelle(niveau.getLibelle())
                .build();
    }
}
