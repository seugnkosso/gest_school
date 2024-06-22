package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.SemestreService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.semestre.SemestreCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SemestreServiceImpl implements SemestreService {
    private final SemestreRepository semestreRepository;
    @Override
    public List<Semestre> getSemestreBykeySearch(String keySearch) {
        return semestreRepository.findAllByLibelleContainsAndActiveTrue(keySearch);
    }
    @Override
    public Page<Semestre> getAllSemestre(Pageable pageable) {
        return semestreRepository.findAllByActiveTrue(pageable);
    }

    @Override
    public Semestre addSemestre(SemestreCreateRequestDto createRequestDto) {
        Semestre semestre = new Semestre();
        semestre.setLibelle(createRequestDto.getLibelle());
        semestre.setListeCour(null);
        return semestreRepository.save(semestre);
    }
}
