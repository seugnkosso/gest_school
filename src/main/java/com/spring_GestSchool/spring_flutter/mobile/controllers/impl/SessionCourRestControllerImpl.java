package com.spring_GestSchool.spring_flutter.mobile.controllers.impl;

import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_flutter.mobile.controllers.SessionCourRestController;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.RestResponsDto;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.sessionCour.SessionCourRestResponseDto;
import com.spring_GestSchool.spring_flutter.services.SessionCourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class SessionCourRestControllerImpl implements SessionCourRestController {
    private final SessionCourService sessionCourService;

    @Override
    public ResponseEntity<?> sesssionCourCour(
            @PathVariable Long idCour
    ) {
        List<SessionCour> allByCour = sessionCourService.getAllByCour(idCour);
        List<SessionCourRestResponseDto> sessionCourRestResponseDtos = allByCour.stream().map(SessionCourRestResponseDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(sessionCourRestResponseDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
