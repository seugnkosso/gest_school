package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.AnneeScolaireService;
import com.rest.gestSchool.gestSchoolRest.web.dto.response.anneeScolaire.AnneeScolaireSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AnneeScolaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnneeScolaireServiceImpl implements AnneeScolaireService {
    private final AnneeScolaireRepository anneeScolaireRepository;
    @Override
    public Page<AnneeScollaire> getAllAnneeScolaire(Pageable pageable) {
        return anneeScolaireRepository.findAllByActiveTrue(pageable);
    }

    @Override
    public AnneeScollaire saveAnneeScoalire(AnneeScolaireSelectDto anneeScolaireSelectDto) {
        AnneeScollaire anneeScollaire = new AnneeScollaire();
        anneeScollaire.setLibelle(anneeScolaireSelectDto.getLibelle());
        anneeScolaireRepository.save(anneeScollaire);
        return null;
    }

    @Override
    public List<AnneeScollaire> getAllAnneScolairebyLibelle(String libelle) {
        return anneeScolaireRepository.findAllByLibelleContains(libelle);
    }
}
