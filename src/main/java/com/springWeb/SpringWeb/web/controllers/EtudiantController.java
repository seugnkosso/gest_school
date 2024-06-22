package com.springWeb.SpringWeb.web.controllers;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface EtudiantController {
    @GetMapping("/etudiants/sessionCour/{idSessionCour}")
    String listeretudiants(
            Model model,
            @PathVariable Long idSessionCour
    );
}
