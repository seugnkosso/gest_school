package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.AttacherService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.AttacherRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.attacher.AttacherSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class AttacherRestControllerImpl implements AttacherRestController {
    private final AttacherService attacherService;
    @Override
    public ResponseEntity<?> searchfiliereByLibelle(String telOrNom) {
        List<Attacher> allByNomOrTel = attacherService.getAllByNomOrTel(telOrNom);
        List<AttacherSelectDto> attacherSelectDtos = allByNomOrTel.stream().map(AttacherSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(attacherSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
