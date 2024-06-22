package com.springWeb.SpringWeb.services.impl;

import com.springWeb.SpringWeb.services.AbsenceService;
import com.springWeb.SpringWeb.web.dto.request.absence.AbsenceCreateDto;
import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository;
    private final SessionCourRepository sessionCourRepository;

    @Override
    public void saveAbsence(AbsenceCreateDto absenceCreateDto) {
        List<Absence> absences = new ArrayList<>();
        for (Long idEt : absenceCreateDto.getIdEtudiant()){
            Absence absence = new Absence();
            absence.setEtudiant(etudiantRepository.findById(idEt).get());
            absence.setSessionCour(sessionCourRepository.findById(absenceCreateDto.getIdSession()).get());
            absences.add(absence);
        }
        absenceRepository.saveAll(absences);
    }

    @Override
    public Page<Absence> getAllByjusticationFalse(Pageable pageable) {
        return absenceRepository.findByJustificationFalse(pageable);
    }

    @Override
    public void validerJustification(Long idAbsence) {
        Absence absence = absenceRepository.findById(idAbsence).get();
        absence.getJustication().setIsvalider(true);
        absenceRepository.save(absence);
    }
}
