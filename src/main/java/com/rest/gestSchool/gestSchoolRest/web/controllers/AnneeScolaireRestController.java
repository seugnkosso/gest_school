package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.anneeScolaire.AnneeScolaireSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface AnneeScolaireRestController {
    @GetMapping("/anneeScolaires")
    ResponseEntity<?> anneeAScolaire(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @GetMapping("/anneeScolaires/libelle/{libelle}")
    ResponseEntity<?> anneeAScolaireByLibelle(
            @PathVariable String libelle
    );
    @PostMapping("/anneeScolaires")
    ResponseEntity<?> creatAnnee(
            @RequestBody AnneeScolaireSelectDto anneeScolaireSelectDto
            );
}
