package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.EtudiantService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.EtudiantRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.etudiant.EtudiantListDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
@RequiredArgsConstructor
public class EtudiantRestControllerImpl implements EtudiantRestController {
    private final EtudiantService etudiantService;
    @Override
    public ResponseEntity<?> etudiant(@PathVariable int id) {
        Etudiant etudiantByid = etudiantService.getEtudiantByid((long)id);
        EtudiantListDto etudiantListDto = EtudiantListDto.toDto(etudiantByid);
        Map<Object, Object> response = RestResponsDto.response(etudiantListDto, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
