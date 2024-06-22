package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Spécialite;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SpécialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class SpécialiteFixture implements CommandLineRunner {
    private final SpécialiteRepository spécialiteRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Spécialite spécialite = new Spécialite();
            spécialite.setLibelle("spécialte" + i);
            spécialiteRepository.save(spécialite);
        }
    }
}
