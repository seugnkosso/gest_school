package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;


import com.rest.gestSchool.gestSchoolRest.services.ClasseService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.ClasseRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.classe.ClasseCreateRequestDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.classe.ClasseListeDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.classe.ClasseSelectDto;

import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
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
public class ClasseRestControllerImpl implements ClasseRestController {
    private final ClasseService classeService;

    @Override
    public ResponseEntity<?> searchClasse(String keySearch) {
        List<Classe> byKetSearche = classeService.getClasseByKetSearche(keySearch);
        List<ClasseSelectDto> selectDtos = byKetSearche.stream().map(ClasseSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(selectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> classes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Classe> allClassePaginate = classeService.getAllClassePaginate(PageRequest.of(page, size));
        Page<ClasseListeDto> classeListeDtos = allClassePaginate.map(ClasseListeDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                classeListeDtos.getContent(),
                classeListeDtos.getTotalElements(),
                classeListeDtos.getTotalPages(),
                (long) classeListeDtos.getContent().size(),
                new int[classeListeDtos.getTotalPages()],
                classeListeDtos.getTotalPages(),
                classeListeDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> classeByLibelle(
            @PathVariable String libelle

    ) {
        Classe byLibelle = classeService.getByLibelle(libelle);
        Map<Object, Object> response;
        if(byLibelle != null){
        ClasseSelectDto classeSelectDto = ClasseSelectDto.toDto(byLibelle);
        response = RestResponsDto.response(classeSelectDto, HttpStatus.OK);
        }else{
        response = RestResponsDto.response(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createClasses(@RequestBody ClasseCreateRequestDto classeCreateRequestDto) {
        Classe save = classeService.save(classeCreateRequestDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
