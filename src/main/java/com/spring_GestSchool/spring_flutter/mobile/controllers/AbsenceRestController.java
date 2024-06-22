package com.spring_GestSchool.spring_flutter.mobile.controllers;

import com.spring_GestSchool.spring_flutter.mobile.dto.request.JustificationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface AbsenceRestController {
    @GetMapping("/absences")
    ResponseEntity<?> listeAbsence(
            @RequestParam String idUser
    );

    @PostMapping("/absences/justification")
    ResponseEntity<?> justifier(
            @RequestBody JustificationRequestDto justificationRequestDto
            );
 
}
