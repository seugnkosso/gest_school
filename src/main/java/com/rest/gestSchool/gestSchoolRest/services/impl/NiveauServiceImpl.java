package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.NiveauService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.niveau.NiveauSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import com.spring_GestSchool.spring_GestSchool.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NiveauServiceImpl implements NiveauService {
    private final NiveauRepository niveauRepository;
    @Override
    public List<Niveau> getAllNiveauByLibelle(String libelle) {
        return niveauRepository.findAllByLibelleContains(libelle);
    }

    @Override
    public Page<Niveau> getAllByPaginate(Pageable pageable) {
        return niveauRepository.findAll(pageable);
    }

    @Override
    public Niveau create(NiveauSelectDto niveauSelectDto) {
        Niveau niveau = new Niveau();
        niveau.setLibelle(niveauSelectDto.getLibelle());
        niveauRepository.save(niveau);
        return null;
    }
}
