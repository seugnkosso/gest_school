package com.spring_GestSchool.spring_flutter.services;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_flutter.mobile.dto.request.JustificationRequestDto;

import java.util.List;

public interface AbsenceService {

    List<Absence> getAllAbsence(Long idEtudiant);

    void justifier(JustificationRequestDto justificationRequestDto);

}
