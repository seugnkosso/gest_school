package com.springWeb.SpringWeb.security.data.fixtures;

import com.spring_GestSchool.spring_GestSchool.data.entities.Absence;
import com.spring_GestSchool.spring_GestSchool.data.entities.Justification;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(2)
@RequiredArgsConstructor
public class justificationFixture implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 2; i < 11; i++) {
            Justification justification = new Justification();
            justification.setMotif("etudiant "+ i + "malade");

            Absence absence = absenceRepository.findById((long) i).get();
            absence.setJustication(justification);
            absenceRepository.save(absence);
        }
    }
}
