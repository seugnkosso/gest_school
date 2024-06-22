package com.springWeb.SpringWeb.services;

import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AbsenceService {
    void saveAbsence(AbsenceCreateDto absenceCreateDto);

    Page<Absence> getAllByjusticationFalse(Pageable pageable);

    void validerJustification(Long idAbsence);
}
