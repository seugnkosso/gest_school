package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.GradeService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.GradeRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class GradeRestControllerImpl implements GradeRestController {
    private final GradeService gradeService;
    @Override
    public ResponseEntity<?> searchGradeByLibelle(
            @PathVariable String libelle
    ) {
        List<Grade> allGradeByLibelle = gradeService.getAllGradeByLibelle(libelle);
        List<GradeSelectDto> gradeSelectDtos = allGradeByLibelle.stream().map(GradeSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(gradeSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> grades(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Grade> allByPaginate = gradeService.getAllByPaginate(PageRequest.of(page, size));
        Page<GradeSelectDto> gradeSelectDtos = allByPaginate.map(GradeSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                gradeSelectDtos.getContent(),
                gradeSelectDtos.getTotalElements(),
                gradeSelectDtos.getTotalPages(),
                (long) gradeSelectDtos.getContent().size(),
                new int[gradeSelectDtos.getTotalPages()],
                gradeSelectDtos.getTotalPages(),
                gradeSelectDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createGrades(@RequestBody GradeSelectDto gradeSelectDto) {
        Grade grade = gradeService.create(gradeSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.OK);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
