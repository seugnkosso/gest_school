package com.rest.gestSchool.gestSchoolRest.web.dto.response.semestre;

import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SemestreSelectDto {
    private Long id;
    private String libelle;

    public static SemestreSelectDto toDto(Semestre semestre) {
        return SemestreSelectDto.builder()
                .id(semestre.getId())
                .libelle(semestre.getLibelle())
                .build();
    }
}
