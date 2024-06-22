package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.filiere.FiliereSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FiliereService {
    List<Filliere> getAllFiliereByLibelle(String libelle);

    Page<Filliere> getAllByPaginate(Pageable pageable);

    Filliere createFiliere(FiliereSelectDto filiereSelectDto);
}
