package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.filiere.FiliereSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface FiliereRestController {
    @GetMapping("/filieres/libelle/{libelle}")
    ResponseEntity<?> searchfiliereByLibelle(
        @PathVariable String libelle
    );

    @GetMapping("/filieres")
    ResponseEntity<?> filieres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @PostMapping("/filieres")
    ResponseEntity<?> createFilieres(
            @RequestBody FiliereSelectDto filiereSelectDto
            );
}
