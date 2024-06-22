package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Filliere;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class FiliereFixture implements CommandLineRunner {
    private  final FiliereRepository filiereRepository;
    private  final ClasseRepository classeRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Filliere filiere = new Filliere();
            filiere.setLibelle("filiere"+i);
            filiereRepository.save(filiere);
        }
    }
}
