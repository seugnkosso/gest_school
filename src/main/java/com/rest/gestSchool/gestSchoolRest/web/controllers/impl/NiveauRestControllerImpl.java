package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.NiveauService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.NiveauRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.niveau.NiveauSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class NiveauRestControllerImpl implements NiveauRestController {
    private final NiveauService niveauService;
    @Override
    public ResponseEntity<?> searchNiveauByLibelle(String libelle) {
        List<Niveau> allNiveauByLibelle = niveauService.getAllNiveauByLibelle(libelle);
        List<NiveauSelectDto> niveauSelectDtos = allNiveauByLibelle.stream().map(NiveauSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(niveauSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> niveaux(int page, int size) {
        Page<Niveau> allByPaginate = niveauService.getAllByPaginate(PageRequest.of(page, size));
        Page<NiveauSelectDto> niveauSelectDtos = allByPaginate.map(NiveauSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                niveauSelectDtos.getContent(),
                niveauSelectDtos.getTotalElements(),
                niveauSelectDtos.getTotalPages(),
                (long) niveauSelectDtos.getContent().size(),
                new int[niveauSelectDtos.getTotalPages()],
                niveauSelectDtos.getTotalPages(),
                niveauSelectDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createniveaux(@RequestBody NiveauSelectDto niveauSelectDto) {
        Niveau niveau = niveauService.create(niveauSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
