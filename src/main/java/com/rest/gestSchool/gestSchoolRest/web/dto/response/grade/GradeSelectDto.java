package com.rest.gestSchool.gestSchoolRest.web.dto.response.grade;

import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradeSelectDto {
    private Long id;
    private String libelle;

    public static GradeSelectDto toDto(Grade grade) {
        return GradeSelectDto.builder()
                .id(grade.getId())
                .libelle(grade.getLibelle())
                .build();
    }
}
