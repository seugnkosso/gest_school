package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.ProfesseurService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.ProfesseurRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurCreateDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurListeDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurSelectDto;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = GlobalVariable.UrlFrontAngulaire)
public class ProfesseurRestControllerImpl implements ProfesseurRestController {
    private final ProfesseurService professeurService;


    @Override
    public ResponseEntity<?> searchProf(String keySearch) {
        List<Professeur> professeurs = professeurService.getProfesseursSearch(keySearch);
        List<ProfesseurSelectDto> professeurSelectDtos = professeurs.stream().map(ProfesseurSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(professeurSelectDtos, HttpStatus.OK);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> professeurs(
            @RequestParam String telephone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Professeur> allProfesseurs = professeurService.getAllProfesseurs(telephone,PageRequest.of(page, size));
        Page<ProfesseurListeDto> professeurListeDtos = allProfesseurs.map(ProfesseurListeDto::toDto);
        Map<Object,Object> response = RestResponsDto.response(
                professeurListeDtos.getContent(),
                professeurListeDtos.getTotalElements(),
                professeurListeDtos.getTotalPages(),
                (long) professeurListeDtos.getContent().size(),
                new int[professeurListeDtos.getTotalPages()],
                professeurListeDtos.getTotalPages(),
                professeurListeDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(
            @RequestBody ProfesseurCreateDto professeurCreateDto
    ) {
        ProfesseurCreateDto professeur = professeurService.createProfesseur(professeurCreateDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
