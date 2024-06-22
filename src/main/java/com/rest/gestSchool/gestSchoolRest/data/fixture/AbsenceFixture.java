package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Justification;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Order(94)
public class AbsenceFixture implements CommandLineRunner {
    private final SessionCourRepository sessionCourRepository;
    private final EtudiantRepository etudiantRepository;
    private final AbsenceRepository absenceRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Absence absence = new Absence();
            if(i % 2 == 0){
                Justification justification = new Justification();
                justification.setDate(new Date());
                justification.setMotif("motif"+i);
                absence.setJustication(new Justification());
            }
            absence.setSessionCour(sessionCourRepository.findById((long) i).get());
            absence.setEtudiant(etudiantRepository.findById((long)i+57).get());
            absenceRepository.save(absence);
        }
            
    }
}
