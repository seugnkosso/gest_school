package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.professeur.ProfesseurCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface ProfesseurRestController {
    @GetMapping("/professeurs/{keySearch}")
    ResponseEntity<?> searchProf(
            @PathVariable String keySearch
    );

    @GetMapping("/professeurs")
    ResponseEntity<?> professeurs(
            @RequestParam String telephone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size

    );
    @PostMapping("/professeurs")
    ResponseEntity<?> create(
            @RequestBody ProfesseurCreateDto professeurCreateDto
            );

}
