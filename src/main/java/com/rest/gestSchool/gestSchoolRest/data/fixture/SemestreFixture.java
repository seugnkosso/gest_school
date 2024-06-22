package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Semestre;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SemestreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class SemestreFixture implements CommandLineRunner {
    private final SemestreRepository semestreRepository;
    private final CourRepository courRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Semestre semestre = new Semestre();
            semestre.setLibelle("semestre"+i);
            semestreRepository.save(semestre);
        }
    }
}
