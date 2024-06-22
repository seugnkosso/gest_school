package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.InscriptionService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.InscriptionRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.inscription.InscriptionCreateDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.inscription.InscriptionSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Inscription;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class InscriptionRestControllerImpl implements InscriptionRestController {
    private final InscriptionService inscriptionService;

    @Override
    public ResponseEntity<?> inscriptions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "") String matricule
    ) {
        Page<Inscription> allInscrits = inscriptionService.getAllInscrits(matricule, PageRequest.of(page, size));
        Page<InscriptionSelectDto> inscriptionSelectDtos = allInscrits.map(InscriptionSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(inscriptionSelectDtos.getContent(),
                inscriptionSelectDtos.getTotalElements(),
                inscriptionSelectDtos.getTotalPages(),
                (long) inscriptionSelectDtos.getContent().size(),
                new int[inscriptionSelectDtos.getTotalPages()],
                inscriptionSelectDtos.getTotalPages(),
                inscriptionSelectDtos.getNumber(),
                HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> inscriptions(
            @RequestBody InscriptionCreateDto inscriptionCreateDto
    ) {
        System.out.println(inscriptionCreateDto.getEtudiant().getTelephone());
        Inscription inscription = inscriptionService.create(inscriptionCreateDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
