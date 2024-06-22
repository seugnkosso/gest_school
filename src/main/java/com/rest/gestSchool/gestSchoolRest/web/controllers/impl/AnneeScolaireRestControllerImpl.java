package com.rest.gestSchool.gestSchoolRest.web.controllers.impl;

import com.rest.gestSchool.gestSchoolRest.services.AnneeScolaireService;
import com.rest.gestSchool.gestSchoolRest.web.controllers.AnneeScolaireRestController;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.RestResponsDto;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.anneeScolaire.AnneeScolaireSelectDto;
import com.spring_GestSchool.spring_GestSchool.config.GlobalVariable;
import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class AnneeScolaireRestControllerImpl implements AnneeScolaireRestController {
    private final AnneeScolaireService anneeScolaireService;
    @Override
    public ResponseEntity<?> anneeAScolaire(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size
    ) {
        Page<AnneeScollaire> allAnneeScolaire = anneeScolaireService.getAllAnneeScolaire(PageRequest.of(page, size));
        Page<AnneeScolaireSelectDto> anneeScolaireSelectDtos = allAnneeScolaire.map(AnneeScolaireSelectDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(anneeScolaireSelectDtos.getContent(),
                anneeScolaireSelectDtos.getTotalElements(),
                anneeScolaireSelectDtos.getTotalPages(),
                (long) anneeScolaireSelectDtos.getContent().size(),
                new int[anneeScolaireSelectDtos.getTotalPages()],
                anneeScolaireSelectDtos.getTotalPages(),
                anneeScolaireSelectDtos.getNumber(),
                HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> anneeAScolaireByLibelle(String libelle) {
        List<AnneeScollaire> allAnneScolairebyLibelle = anneeScolaireService.getAllAnneScolairebyLibelle(libelle);
        List<AnneeScolaireSelectDto> anneeScolaireSelectDtos = allAnneScolairebyLibelle.stream().map(AnneeScolaireSelectDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(anneeScolaireSelectDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> creatAnnee(
            @RequestBody AnneeScolaireSelectDto anneeScolaireSelectDto
    ) {
        anneeScolaireService.saveAnneeScoalire(anneeScolaireSelectDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
