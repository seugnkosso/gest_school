package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Salle;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SalleRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SessionCourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class SalleFixture implements CommandLineRunner {
    private final SessionCourRepository sessionCourRepository;
    private final SalleRepository salleRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Salle salle = new Salle();
            salle.setLibelle("salle"+i);
            salle.setNumero((long)200+i);
            salle.setNbrPlace((long)40+i);
//            salle.getListeSessionCour().add(sessionCourRepository.findById((long)i).get());
            salleRepository.save(salle);
        }
    }
}
