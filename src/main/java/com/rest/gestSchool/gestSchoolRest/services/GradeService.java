package com.rest.gestSchool.gestSchoolRest.services;


import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGradeByLibelle(String libelle);

    Page<Grade> getAllByPaginate(Pageable pageable);

    Grade create(GradeSelectDto gradeSelectDto);
}
