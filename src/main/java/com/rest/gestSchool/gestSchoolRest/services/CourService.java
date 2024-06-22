package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.cour.CourCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourService {

    Page<Cour> getAllCourprofesseurId(Long idProfesseur, String telephone, Pageable pageable);
    Page<Cour> getAllCour(String tel,Pageable pageable);

    CourCreateRequestDto save(CourCreateRequestDto dto);
}
