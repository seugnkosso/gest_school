package com.spring_GestSchool.spring_flutter.services.impl;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import com.spring_GestSchool.spring_flutter.mobile.dto.request.JustificationRequestDto;
import com.spring_GestSchool.spring_flutter.services.AbsenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    @Override
    public List<Absence> getAllAbsence(Long idEtudiant) {
        return absenceRepository.findAllByEtudiantId(idEtudiant);
    }

    @Override
    public void justifier(JustificationRequestDto justificationRequestDto) {
        Absence absence = absenceRepository.findById(justificationRequestDto.getIdAbsence()).get();
        absence.getJustication().setMotif(justificationRequestDto.getMotif());
        absence.getJustication().setDate(new Date());
        absenceRepository.save(absence);
    }
}
