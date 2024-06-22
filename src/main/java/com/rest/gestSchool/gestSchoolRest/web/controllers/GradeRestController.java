package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface GradeRestController {
    @GetMapping("/grades/libelle/{libelle}")
    ResponseEntity<?> searchGradeByLibelle(
        @PathVariable String libelle
    );

    @GetMapping("/grades")
    ResponseEntity<?> grades(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
            );
    @PostMapping("/grades")
    ResponseEntity<?> createGrades(
            @RequestBody GradeSelectDto gradeSelectDto
            );

}
