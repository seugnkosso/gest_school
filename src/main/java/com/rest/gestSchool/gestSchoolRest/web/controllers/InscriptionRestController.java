package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.inscription.InscriptionCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface InscriptionRestController {
    @GetMapping("/Inscriptions")
    ResponseEntity<?> inscriptions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "") String matricule
    );

    @PostMapping("/Inscriptions")
    ResponseEntity<?> inscriptions(
            @RequestBody InscriptionCreateDto inscriptionCreateDto
    );
}
