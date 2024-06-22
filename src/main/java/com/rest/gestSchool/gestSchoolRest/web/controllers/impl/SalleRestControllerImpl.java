package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.SalleService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.SalleRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.salle.SalleCreateDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.salle.SalleListeDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class SalleRestControllerImpl implements SalleRestController {
    private final SalleService salleService;
    @Override
    public ResponseEntity<?> Salles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Salle> allSallePage = salleService.getAllSallePage(PageRequest.of(page, size));
        Page<SalleListeDto> salleListeDtos = allSallePage.map(SalleListeDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                salleListeDtos.getContent(),
                salleListeDtos.getTotalElements(),
                salleListeDtos.getTotalPages(),
                (long) salleListeDtos.getContent().size(),
                new int[salleListeDtos.getTotalPages()],
                salleListeDtos.getTotalPages(),
                salleListeDtos.getNumber(),
                HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createSalles(
            @RequestBody SalleCreateDto salleCreateDto
    ) {
        salleService.CreateSalle(salleCreateDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> sesssionCourheure(String libelle, String date, String heure, String heureFin) {
        List<Salle> salles = salleService.getAllSalleByLibelleAndNoSessionCour(libelle, date, heure, heureFin);
        List<SalleListeDto> salleListeDtos = salles.stream().map(SalleListeDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(salleListeDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
