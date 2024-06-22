package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.niveau.NiveauSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface NiveauRestController {
    @GetMapping("/niveaux/libelle/{libelle}")
    ResponseEntity<?> searchNiveauByLibelle(
        @PathVariable String libelle
    );
    @GetMapping("/niveaux")
    ResponseEntity<?> niveaux(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @PostMapping("/niveaux")
    ResponseEntity<?> createniveaux(
            @RequestBody NiveauSelectDto niveauSelectDto
            );
}
