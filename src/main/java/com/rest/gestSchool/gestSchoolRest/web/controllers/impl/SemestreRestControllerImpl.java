package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;


import com.rest.gestSchool.gestSchoolRest.services.SemestreService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.SemestreRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.semestre.SemestreSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class SemestreRestControllerImpl implements SemestreRestController {
    private final SemestreService semestreService;

    @Override
    public ResponseEntity<?> searchSemestre(String keySearch) {
        List<Semestre> bykeySearch = semestreService.getSemestreBykeySearch(keySearch);
        List<SemestreSelectDto> semestreSelectDtos = bykeySearch.stream().map(SemestreSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(semestreSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> Semestres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Semestre> semestres = semestreService.getAllSemestre(PageRequest.of(page, size));
        Page<SemestreSelectDto> semestreSelectDtos = semestres.map(SemestreSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                semestreSelectDtos.getContent(),
                semestreSelectDtos.getTotalElements(),
                semestreSelectDtos.getTotalPages(),
                (long) semestreSelectDtos.getContent().size(),
                new int[semestreSelectDtos.getTotalPages()],
                semestreSelectDtos.getTotalPages(),
                semestreSelectDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createSemestres(@RequestBody SemestreCreateRequestDto semestreCreateRequestDto) {
        Semestre semestre = semestreService.addSemestre(semestreCreateRequestDto);
        SemestreSelectDto semestreSelectDto = SemestreSelectDto.toDto(semestre);
        Map<Object, Object> response = RestResponsDto.response(semestreSelectDto, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
