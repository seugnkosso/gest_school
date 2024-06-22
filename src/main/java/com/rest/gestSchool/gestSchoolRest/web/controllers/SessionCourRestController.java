package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.sessionCour.SessionCourCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface SessionCourRestController {
    @GetMapping("/sessionCours/cour/{idCour}")
    ResponseEntity<?> sesssionCourCour(
            @PathVariable Long idCour,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String dateDebut,
            @RequestParam String dateFin
    );

    @GetMapping("/sessionCours/cour/{idCour}/professeur/{idProf}")
    ResponseEntity<?> sesssionCourCourProf(
            @PathVariable Long idCour,
            @PathVariable Long idProf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String dateDebut,
            @RequestParam String dateFin
    );

    @GetMapping("/sessionCours/heure/{heure}/{heureFin}/{date}/{idCour}")
    ResponseEntity<?> sesssionCourheure(
            @PathVariable String date,
            @PathVariable String heure,
            @PathVariable String heureFin,
            @PathVariable int idCour
    );

    @PostMapping("/sessionCours")
    ResponseEntity<?> sesssionCourheure(
            @RequestBody SessionCourCreateDto sessionCourCreateDto
    );
}
