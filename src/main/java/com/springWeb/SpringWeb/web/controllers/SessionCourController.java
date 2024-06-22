package com.springWeb.SpringWeb.web.controllers;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface SessionCourController {
    @GetMapping("/sessionCours/professeur/{idProf}")
    String listerProfesseur(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @PathVariable Long idProf
    );
    @GetMapping("/sessionCours/valider/{idSession}/{idP}")
    String validerSession(
            @PathVariable Long idSession,
            @PathVariable Long idP
    );
}
