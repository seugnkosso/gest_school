package com.springWeb.SpringWeb.web.controllers;

import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public interface AbsentController {
    @PostMapping("/absents")
    String saveAbsent(
            @ModelAttribute AbsenceCreateDto absenceCreateDto
    );

    @GetMapping("/absence/nonJustifier")
    String AbsensNonJustifier(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @GetMapping("/absence/justification/valider")
    String validerJustification(
            @RequestParam Long idAbsence
    );
}
