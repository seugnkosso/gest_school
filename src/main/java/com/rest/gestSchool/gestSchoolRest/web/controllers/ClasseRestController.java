package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.classe.ClasseCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface ClasseRestController {
    @GetMapping("/classes/{keySearch}")
    ResponseEntity<?> searchClasse(
        @PathVariable String keySearch
    );
    @GetMapping("/classes")
    ResponseEntity<?> classes(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @GetMapping("/classes/Onelibelle/{libelle}")
    ResponseEntity<?> classeByLibelle(
        @PathVariable String libelle
    );
    @PostMapping("/classes")
    ResponseEntity<?> createClasses(
            @RequestBody ClasseCreateRequestDto classeCreateRequestDto
            );
}
