package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.ProfesseurService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import com.spring_GestSchool.spring_GestSchool.data.repositories.GradeRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SpécialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesseurServiceImpl implements ProfesseurService {
    private final ProfesseurRepository professeurRepository;
    private final GradeRepository gradeRepository;
    private final SpécialiteRepository spécialiteRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Professeur> getProfesseursSearch(String keySearch) {
        List<Professeur> professeurList = professeurRepository.findByTelAndNomComplet(keySearch,keySearch);
        return professeurList;
    }

    @Override
    public Page<Professeur> getAllProfesseurs(String telephone,Pageable pageable) {
        return professeurRepository.findAllByTelephone(telephone,pageable);
    }

    @Override
    public ProfesseurCreateDto createProfesseur(ProfesseurCreateDto pCreateDto) {
        Professeur professeur = new Professeur();
        professeur.setNomComplet(pCreateDto.getNomComplet());
        professeur.setTelephone(pCreateDto.getTelephone());
        professeur.setEmail(pCreateDto.getEmail());
        professeur.setPassword(passwordEncoder.encode("passer"));
        professeur.setUsername(pCreateDto.getUsername());
        professeur.setListeGrade(getAllGradesSelect(pCreateDto.getGrades()));
        professeur.setSpécialite(spécialiteRepository.findById(pCreateDto.getSpecialite()).get());
        professeurRepository.save(professeur);
        getAllGradesSelect(pCreateDto.getGrades()).forEach(grade -> {
            grade.getListeProfesseur().add(professeur);
            gradeRepository.save(grade);
        });
        return null;
    }

    private List<Grade> getAllGradesSelect(List<Long> gradeSelectDtos) {
        return gradeSelectDtos.stream().map(gradeSelectDto -> gradeRepository.findById(gradeSelectDto).get()).collect(Collectors.toList());
    };
}
