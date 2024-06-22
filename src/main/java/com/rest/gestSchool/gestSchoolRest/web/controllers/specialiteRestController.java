package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite.SpecialteSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface specialiteRestController {
    @GetMapping("/specialites/libelle/{libelle}")
    ResponseEntity<?> searchSpecialteByLibelle(
        @PathVariable String libelle
    );
    @GetMapping("/specialites")
    ResponseEntity<?> specialites(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );

    @PostMapping("/specialites")
    ResponseEntity<?> createSpecialites(
            @RequestBody SpecialteSelectDto specialteSelectDto
    );
}
