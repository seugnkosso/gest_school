package com.rest.gestSchool.gestSchoolRest.security.controllers;

import com.rest.gestSchool.gestSchoolRest.security.controllers.dtos.AuthenticationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SecurityController {
    @PostMapping("/login")
    ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto);
}
