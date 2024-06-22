package com.spring_GestSchool.spring_flutter.mobile.controllers.impl;


import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_flutter.mobile.controllers.CourRestController;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.RestResponsDto;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.cour.CourRestResponseDto;
import com.spring_GestSchool.spring_flutter.services.CourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CourRestControllerImpl implements CourRestController {
    private final CourService courService;

    @Override
    public ResponseEntity<?> listeCour(
            @RequestParam String idUser
    ) {
        List<Cour> cours = courService.getAllCour(Long.valueOf(idUser));
        List<CourRestResponseDto> courRestResponseDtos = cours.stream().map(CourRestResponseDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(courRestResponseDtos, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
