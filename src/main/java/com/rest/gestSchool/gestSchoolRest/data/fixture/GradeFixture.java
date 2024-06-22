package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Grade;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import com.spring_GestSchool.spring_GestSchool.data.repositories.GradeRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(4)
public class GradeFixture implements CommandLineRunner {
    private final GradeRepository gradeRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Grade grade = new Grade();
            grade.setLibelle("grade"+i);
            List<Professeur> listProfesseur = new ArrayList<>();
            listProfesseur.add(professeurRepository.findById((long)i+19).get());
            grade.setListeProfesseur(listProfesseur);
            gradeRepository.save(grade);
        }
    }
}
