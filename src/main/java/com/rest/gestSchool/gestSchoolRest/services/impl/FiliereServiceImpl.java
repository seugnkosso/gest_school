package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.FiliereService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.filiere.FiliereSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.repositories.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FiliereServiceImpl implements FiliereService {
    private final FiliereRepository filiereRepository;
    @Override
    public List<Filliere> getAllFiliereByLibelle(String libelle) {
        return  filiereRepository.findAllByLibelleContains(libelle);
    }

    @Override
    public Page<Filliere> getAllByPaginate(Pageable pageable) {
        return filiereRepository.findAll(pageable);
    }

    @Override
    public Filliere createFiliere(FiliereSelectDto filiereSelectDto) {
        Filliere filliere = new Filliere();
        filliere.setLibelle(filiereSelectDto.getLibelle());
        filiereRepository.save(filliere);
        return null;
    }
}
