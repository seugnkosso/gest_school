package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.SessionCour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SalleRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Order(93)
public class SessionCourFixture implements CommandLineRunner {
    private final AbsenceRepository absenceRepository;
    private final SalleRepository salleRepository;
    private final CourRepository courRepository;
    private final SessionCourRepository sessionCourRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            SessionCour sessionCour = new SessionCour();
            sessionCour.setDate(new Date());
            sessionCour.setHeureDebut(new Date());
            sessionCour.setHeureFin(new Date());
            sessionCour.setNbrHeure((long) 2 + i);
            sessionCour.setCour(courRepository.findById((long) i).get());
            sessionCour.setSalle(salleRepository.findById((long) i).get());
            sessionCourRepository.save(sessionCour);
        }
    }
}
