package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.cour.CourCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface CourRestController {
    @GetMapping("/cours")
    ResponseEntity<?> listeCour(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String tel
    );
    @GetMapping("/cours/professeur")
    ResponseEntity<?> listeCourProf(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam int idProf,
            @RequestParam String tel

    );

    @PostMapping("/cours")
    ResponseEntity<?> saveCour(
            @RequestBody
            CourCreateRequestDto courCreateRequestDto
    );

}
