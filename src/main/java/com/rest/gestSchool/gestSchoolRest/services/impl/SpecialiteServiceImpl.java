package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.SpecialiteService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite.SpecialteSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SpécialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialiteServiceImpl implements SpecialiteService {
    private final SpécialiteRepository spécialiteRepository;
    @Override
    public List<Spécialite> getAllSpecialteByLibelle(String libelle) {
        return spécialiteRepository.findAllByLibelleContains(libelle);
    }

    @Override
    public Page<Spécialite> getAllBypaginate(Pageable pageable) {
        return spécialiteRepository.findAll(pageable);
    }

    @Override
    public Spécialite create(SpecialteSelectDto specialteSelectDto) {
        Spécialite spécialite = new Spécialite();
        spécialite.setLibelle(specialteSelectDto.getLibelle());
        spécialiteRepository.save(spécialite);
        return null;
    }
}
