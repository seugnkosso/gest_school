package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.inscription.InscriptionCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface EtudiantRestController {
    @GetMapping("/Etudiants/{id}")
    ResponseEntity<?> etudiant(
            @PathVariable int id
    );
}
