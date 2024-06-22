package com.rest.gestSchool.gestSchoolRest.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface AttacherRestController {
    @GetMapping("/attachers/telOrNom/{telOrNom}")
    ResponseEntity<?> searchfiliereByLibelle(
        @PathVariable String telOrNom
    );
}
