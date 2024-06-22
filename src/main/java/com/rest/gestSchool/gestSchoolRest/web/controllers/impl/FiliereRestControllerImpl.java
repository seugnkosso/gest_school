package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.FiliereService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.FiliereRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.filiere.FiliereSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class FiliereRestControllerImpl implements FiliereRestController {
    private final FiliereService filiereService;
    @Override
    public ResponseEntity<?> searchfiliereByLibelle(
            @PathVariable String libelle
    ) {
        List<Filliere> allFiliereByLibelle = filiereService.getAllFiliereByLibelle(libelle);
        List<FiliereSelectDto> filiereSelectDtos = allFiliereByLibelle.stream().map(FiliereSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(filiereSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> filieres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<Filliere> allByPaginate = filiereService.getAllByPaginate(PageRequest.of(page, size));
        Page<FiliereSelectDto> filiereSelectDtos = allByPaginate.map(FiliereSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                filiereSelectDtos.getContent(),
                filiereSelectDtos.getTotalElements(),
                filiereSelectDtos.getTotalPages(),
                (long) filiereSelectDtos.getContent().size(),
                new int[filiereSelectDtos.getTotalPages()],
                filiereSelectDtos.getTotalPages(),
                filiereSelectDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createFilieres(
            @RequestBody FiliereSelectDto filiereSelectDto
    ){
        filiereService.createFiliere(filiereSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
