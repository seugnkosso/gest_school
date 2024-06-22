package com.springWeb.SpringWeb.web.dto.response.professeur;

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
