package com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite.SpecialteSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesseurCreateDto {
    private String nomComplet;
    private String telephone;
    private String email;
    private String username;
    private String searchSpecilite;
    private Long specialite;
    private String searchGrade;
    private List<Long> grades;
}
