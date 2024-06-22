package com.rest.gestSchool.gestSchoolRest.services;

import com.rest.gestSchool.gestSchoolRest.web.dto.request.salle.SalleCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Module;
import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalleService {
    Page<Salle> getAllSallePage(Pageable pageable);

    Salle CreateSalle(SalleCreateDto salleCreateDto);

    List<Salle> getAllSalleByLibelleAndNoSessionCour(String libelle,String date,String HeureDebut,String heureFin);
}
