package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface SemestreRestController {
    @GetMapping("/semestres/{keySearch}")
    ResponseEntity<?> searchSemestre(
        @PathVariable String keySearch
    );
    @GetMapping("/semestres")
    ResponseEntity<?> Semestres(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );

    @PostMapping("/semestres")
    ResponseEntity<?> createSemestres(
            @RequestBody SemestreCreateRequestDto semestreCreateRequestDto
            );

}
