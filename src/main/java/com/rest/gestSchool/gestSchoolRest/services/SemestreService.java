package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SemestreService {
    List<Semestre> getSemestreBykeySearch(String keySearch);

    Page<Semestre> getAllSemestre(Pageable pageable);

    Semestre addSemestre(SemestreCreateRequestDto createRequestDto);
}
