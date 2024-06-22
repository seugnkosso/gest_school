package com.rest.gestSchool.gestSchoolRest.web.dto.response.filiere;

import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FiliereSelectDto {
    private Long id;
    private String libelle;

    public static FiliereSelectDto toDto(Filliere filiere) {
        return FiliereSelectDto.builder()
                .id(filiere.getId())
                .libelle(filiere.getLibelle())
                .build();
    }
}
