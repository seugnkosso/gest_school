package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Niveau;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class NiveauFixture implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final NiveauRepository niveauRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Niveau niveau = new Niveau();
            niveau.setLibelle("niveau"+i);
            niveauRepository.save(niveau);
        }
    }
}
