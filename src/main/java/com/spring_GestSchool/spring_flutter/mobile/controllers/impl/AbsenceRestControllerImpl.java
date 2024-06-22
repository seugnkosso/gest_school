package com.spring_GestSchool.spring_flutter.mobile.controllers.impl;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_flutter.mobile.controllers.AbsenceRestController;
import com.spring_GestSchool.spring_flutter.mobile.dto.request.JustificationRequestDto;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.RestResponsDto;
import com.spring_GestSchool.spring_flutter.mobile.dto.response.absence.AbsenceRestResponseDto;
import com.spring_GestSchool.spring_flutter.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AbsenceRestControllerImpl implements AbsenceRestController {
    private final AbsenceService absenceService;
    @Override
    public ResponseEntity<?> listeAbsence(String idUser) {
        List<Absence> allAbsence = absenceService.getAllAbsence(Long.valueOf(idUser));
        List<AbsenceRestResponseDto> absenceRestResponseDtos = allAbsence.stream().map(AbsenceRestResponseDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(absenceRestResponseDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> justifier(JustificationRequestDto justificationRequestDto) {
        absenceService.justifier(justificationRequestDto);
        return new ResponseEntity<>(null,HttpStatus.OK) ;
    }
}
