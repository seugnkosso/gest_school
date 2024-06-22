package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.classe.ClasseCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClasseService {

    List<Classe> getClasseByKetSearche(String keySearch);

    Page<Classe> getAllClassePaginate(Pageable pageable);

    Classe save(ClasseCreateRequestDto classeCreateRequestDto);

    Classe getByLibelle(String libelle);
}
