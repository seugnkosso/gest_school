package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.salle.SalleCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface SalleRestController {
    @GetMapping("/Salles")
    ResponseEntity<?> Salles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
            );

    @PostMapping("/Salles")
    ResponseEntity<?> createSalles(
            @RequestBody SalleCreateDto salleCreateDto
            );

    @GetMapping("/Salles/libelle/{heure}/{heureFin}/{date}")
    ResponseEntity<?> sesssionCourheure(
            @RequestParam String libelle,
            @PathVariable String date,
            @PathVariable String heure,
            @PathVariable String heureFin
    );
}
