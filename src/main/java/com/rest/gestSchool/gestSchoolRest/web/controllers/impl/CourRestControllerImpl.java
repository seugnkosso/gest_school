package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;


import com.rest.gestSchool.gestSchoolRest.services.CourService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.CourRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.cour.CourCreateRequestDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.cour.CourRestResponseDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = GlobalVariable.UrlFrontAngulaire)
public class CourRestControllerImpl implements CourRestController {
    private final CourService courService;

    @Override
    public ResponseEntity<?> listeCour(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String tel

    ) {
        Page<Cour> courprofesseurId = courService.getAllCour(tel,PageRequest.of(page, size));
        return getResponseEntity(courprofesseurId);
    }

    @Override
    public ResponseEntity<?> listeCourProf(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam int idProf,
            @RequestParam String tel

    ) {
        Page<Cour> allCourByprofId = courService.getAllCourprofesseurId((long) idProf,tel, PageRequest.of(page, size));
        return getResponseEntity(allCourByprofId);
    }

    private ResponseEntity<?> getResponseEntity(Page<Cour> allCourByprofId) {
        Page<CourRestResponseDto> courRestResponseDtos = allCourByprofId.map(CourRestResponseDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(courRestResponseDtos.getContent(),
                courRestResponseDtos.getTotalElements(),
                courRestResponseDtos.getTotalPages(),
                (long) courRestResponseDtos.getContent().size(),
                new int[courRestResponseDtos.getTotalPages()],
                courRestResponseDtos.getTotalPages(),
                courRestResponseDtos.getNumber(),
                HttpStatus.OK
        );

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveCour(
            @RequestBody
            CourCreateRequestDto courCreateRequestDto
    ) {
            Map<Object, Object> response;
            CourCreateRequestDto courDto = courService.save(courCreateRequestDto);
            response = RestResponsDto.response(courDto, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
