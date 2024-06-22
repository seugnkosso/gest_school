package com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur;

import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesseurSelectDto {
    private Long id;
    private String nomComplet;

    public static ProfesseurSelectDto toDto(Professeur professeur) {
        return ProfesseurSelectDto.builder()
                .id(professeur.getId())
                .nomComplet(professeur.getNomComplet())
                .build();
    }
}
