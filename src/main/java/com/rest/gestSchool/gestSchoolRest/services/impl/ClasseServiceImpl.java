package com.rest.gestSchool.gestSchoolRest.services.impl;

import com.rest.gestSchool.gestSchoolRest.services.ClasseService;
import com.rest.gestSchool.gestSchoolRest.web.dto.request.classe.ClasseCreateRequestDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;
    private final AttacheRepository attacheRepository;
    private final FiliereRepository filiereRepository;
    private final NiveauRepository niveauRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public List<Classe> getClasseByKetSearche(String keySearch) {
        return classeRepository.findAllByLibelleContainsAndActiveTrue(keySearch);
    }

    @Override
    public Page<Classe> getAllClassePaginate(Pageable pageable) {
        return classeRepository.findAllByActiveTrue(pageable);
    }

    @Override
    public Classe save(ClasseCreateRequestDto classeCreateRequestDto) {
        Classe classe = new Classe();
        classe.setLibelle(classeCreateRequestDto.getLibelle());
        classe.setAttacher(attacheRepository.findById(classeCreateRequestDto.getAttacher()).get());
        classe.setFiliere(filiereRepository.findById(classeCreateRequestDto.getFiliere()).get());
        classe.setNiveau(niveauRepository.findById(classeCreateRequestDto.getNiveau()).get());
        classe.setAnneeScolaire(anneeScolaireRepository.findById(classeCreateRequestDto.getAnneeScolaire()).get());
        classeRepository.save(classe);
        return null;
    }

    @Override
    public Classe getByLibelle(String libelle) {
        return classeRepository.findByLibelleContains(libelle);
    }
}
