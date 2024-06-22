package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.SpecialiteService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.specialiteRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite.SpecialteSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
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
public class specialiteRestControllerImpl implements specialiteRestController {
    private final SpecialiteService specialiteService;
    @Override
    public ResponseEntity<?> searchSpecialteByLibelle(
            @PathVariable String libelle
    ) {
        List<Spécialite> allSpecialteByLibelle = specialiteService.getAllSpecialteByLibelle(libelle);
        List<SpecialteSelectDto> specialteSelectDtos = allSpecialteByLibelle.stream().map(SpecialteSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(specialteSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> specialites(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Spécialite> allBypaginate = specialiteService.getAllBypaginate(PageRequest.of(page, size));
        Page<SpecialteSelectDto> specialteSelectDtos = allBypaginate.map(SpecialteSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                specialteSelectDtos.getContent(),
                specialteSelectDtos.getTotalElements(),
                specialteSelectDtos.getTotalPages(),
                (long) specialteSelectDtos.getContent().size(),
                new int[specialteSelectDtos.getTotalPages()],
                specialteSelectDtos.getTotalPages(),
                specialteSelectDtos.getNumber(),
                HttpStatus.OK
        );


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createSpecialites(
            @RequestBody SpecialteSelectDto specialteSelectDto
    ) {
        specialiteService.create(specialteSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
