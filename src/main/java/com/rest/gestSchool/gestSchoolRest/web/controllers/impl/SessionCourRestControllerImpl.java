package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.SessionCourService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.SessionCourRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.sessionCour.SessionCourCreateDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.sessionCour.SessionCourRestResponseDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class SessionCourRestControllerImpl implements SessionCourRestController {
    private final SessionCourService sessionCourService;

    @Override
    public ResponseEntity<?> sesssionCourCour(
            @PathVariable Long idCour,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String dateDebut,
            @RequestParam String dateFin
    ) {
        Page<SessionCour> allByCour = sessionCourService.getAllByCour(idCour, dateDebut, dateFin, PageRequest.of(page, size));
        return getResponseEntity(allByCour);
    }

    @Override
    public ResponseEntity<?> sesssionCourCourProf(
            @PathVariable Long idCour,
            @PathVariable Long idProf,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String dateDebut,
            @RequestParam String dateFin
    ) {
        Page<SessionCour> allByCour = sessionCourService.getAllByCourProf(idCour, idProf, dateDebut, dateFin, PageRequest.of(page, size));
        return getResponseEntity(allByCour);
    }

    private ResponseEntity<?> getResponseEntity(Page<SessionCour> allByCour) {
        Page<SessionCourRestResponseDto> sessionCourRestResponseDtos = allByCour.map(SessionCourRestResponseDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                sessionCourRestResponseDtos.getContent(),
                sessionCourRestResponseDtos.getTotalElements(),
                sessionCourRestResponseDtos.getTotalPages(),
                (long) sessionCourRestResponseDtos.getContent().size(),
                new int[sessionCourRestResponseDtos.getTotalPages()],
                sessionCourRestResponseDtos.getTotalPages(),
                sessionCourRestResponseDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> sesssionCourheure(
            @PathVariable String date,
            @PathVariable String heure,
            @PathVariable String heureFin,
            @PathVariable int idCour
    ) {
        Map<Object, Object> SessionIsExiste = new HashMap<>();
        SessionIsExiste.put("SessionProfExist", sessionCourService.SessionProfExist(idCour, heure, heureFin, date));
        SessionIsExiste.put("SessionClasseExist", sessionCourService.SessionClasseExist(idCour, heure, heureFin, date));
        Map<Object, Object> response = RestResponsDto.response(SessionIsExiste, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> sesssionCourheure(SessionCourCreateDto sessionCourCreateDto) {
        SessionCour create = sessionCourService.Create(sessionCourCreateDto);
        Map<Object, Object> response = RestResponsDto.response(create, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
