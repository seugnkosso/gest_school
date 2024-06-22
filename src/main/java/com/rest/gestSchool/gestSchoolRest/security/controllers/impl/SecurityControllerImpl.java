package com.rest.gestSchool.gestSchoolRest.security.controllers.impl;


import com.rest.gestSchool.gestSchoolRest.security.controllers.SecurityController;
import com.rest.gestSchool.gestSchoolRest.security.controllers.dtos.AuthenticationRequestDto;
import com.rest.gestSchool.gestSchoolRest.security.controllers.dtos.TokenReponseDto;
import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import com.rest.gestSchool.gestSchoolRest.security.service.impl.JwtService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
@Slf4j
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        log.info(authenticationRequestDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            //Generer le token
             String token= jwtService.createToken(authenticationRequestDto.getUsername(),new HashMap<String,Object>());
             TokenReponseDto tokenDto = TokenReponseDto.builder()
                     .id(securityService.getUserByUserName(authenticationRequestDto.getUsername()).getId())
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponsDto.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponsDto.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }
}
