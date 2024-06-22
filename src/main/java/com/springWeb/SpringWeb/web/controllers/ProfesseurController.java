package com.springWeb.SpringWeb.web.controllers;

import com.springWeb.SpringWeb.web.dto.request.professeur.searchprof;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProfesseurController {
    @GetMapping("/professeurs")
    String listerProfesseur(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam(defaultValue = "")  String tel
    );
}
