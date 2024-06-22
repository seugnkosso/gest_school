package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.GradeService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.grade.GradeSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import com.spring_GestSchool.spring_GestSchool.data.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    @Override
    public List<Grade> getAllGradeByLibelle(String libelle) {
        return gradeRepository.findAllByLibelleContains(libelle);
    }

    @Override
    public Page<Grade> getAllByPaginate(Pageable pageable) {
        return gradeRepository.findAll(pageable);
    }

    @Override
    public Grade create(GradeSelectDto gradeSelectDto) {
        Grade grade = new Grade();
        grade.setLibelle(gradeSelectDto.getLibelle());
        gradeRepository.save(grade);
        return null;
    }

}
