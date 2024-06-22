package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.niveau.NiveauSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NiveauService {
    List<Niveau> getAllNiveauByLibelle(String libelle);

    Page<Niveau> getAllByPaginate(Pageable pageable);

    Niveau create(NiveauSelectDto niveauSelectDto);
}
