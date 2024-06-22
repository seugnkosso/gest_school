package com.spring_GestSchool.spring_flutter.mobile.controllers;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface SessionCourRestController {
    @GetMapping("/sessionCours/cour/{idCour}")
    ResponseEntity<?> sesssionCourCour(
            @PathVariable Long idCour
    );
}
