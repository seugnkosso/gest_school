package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurCreateDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurListeDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfesseurService {
    List<Professeur> getProfesseursSearch(String keySearch);

    Page<Professeur> getAllProfesseurs(String telephone,Pageable pageable);

    ProfesseurCreateDto createProfesseur(ProfesseurCreateDto professeurCreateDto);
}
