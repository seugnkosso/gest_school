package com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
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
public class ProfesseurListeDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private String email;
    private String specialite;
    private String grade;


    public static ProfesseurListeDto toDto(Professeur professeur) {
        return ProfesseurListeDto.builder()
                .id(professeur.getId())
                .nomComplet(professeur.getNomComplet())
                .email(professeur.getEmail())
                .telephone(professeur.getTelephone())
                .specialite(professeur.getSpécialite().getLibelle())
                .grade(getGrades(professeur.getListeGrade()))
                .build();
    }

    private static String getGrades(List<Grade> grades){
        String grad = "| ";
        for (int i = 0; i < grades.size(); i++) {
            grad += grades.get(i).getLibelle() + " | ";
        }
        return grad;
    }
}
