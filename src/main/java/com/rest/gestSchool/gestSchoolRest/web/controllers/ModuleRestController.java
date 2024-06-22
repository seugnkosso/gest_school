package com.rest.gestSchool.gestSchoolRest.web.controllers;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.module.ModuleSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface ModuleRestController {
    @GetMapping("/modules/{keySearch}")
    ResponseEntity<?> searchModule(
        @PathVariable String keySearch
    );
    @GetMapping("/modules")
    ResponseEntity<?> modules(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );
    @PostMapping("/modules")
    ResponseEntity<?> crateModules(
            @RequestBody ModuleSelectDto moduleSelectDto
            );
}
