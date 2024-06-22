package com.rest.gestSchool.gestSchoolRest.services;


import com.rest.gestSchool.gestSchoolRest.web.dto.response.specialite.SpecialteSelectDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpecialiteService {
    List<Spécialite> getAllSpecialteByLibelle(String libelle);

    Page<Spécialite> getAllBypaginate(Pageable pageable);

    Spécialite create(SpecialteSelectDto specialteSelectDto);
}
