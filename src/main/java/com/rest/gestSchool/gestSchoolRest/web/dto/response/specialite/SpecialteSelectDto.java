package com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite;

import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpecialteSelectDto {
    private Long id;
    private String libelle;

    public static SpecialteSelectDto toDto(Spécialite spécialite) {
        return SpecialteSelectDto.builder()
                .id(spécialite.getId())
                .libelle(spécialite.getLibelle())
                .build();
    }
}
