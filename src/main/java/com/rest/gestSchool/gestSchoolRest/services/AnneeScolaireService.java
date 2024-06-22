package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.response.anneeScolaire.AnneeScolaireSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnneeScolaireService {
    Page<AnneeScollaire> getAllAnneeScolaire(Pageable pageable);
    AnneeScollaire saveAnneeScoalire(AnneeScolaireSelectDto anneeScolaireSelectDto);

    List<AnneeScollaire> getAllAnneScolairebyLibelle(String libelle);
}
