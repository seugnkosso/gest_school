package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(5)
public class CourFixture implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final SessionCourRepository sessionCourRepository;
    private final SemestreRepository semestreRepository;
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final CourRepository courRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Cour cour = new Cour();
            cour.setNbrHeure((long) 20 + i);
            if (i % 2 == 0) {
                cour.setEtatCour("en ligne");
            } else {
                cour.setEtatCour("présentiel");
            }
            cour.setProfesseur(professeurRepository.findById((long)i+19).get());
            if (i % 2 == 0) {
                cour.setAnneeScolaire(anneeScolaireRepository.findById((long) 1).get());
            } else {
                cour.setAnneeScolaire(anneeScolaireRepository.findById((long) 2).get());
            }
            cour.setSemestre(semestreRepository.findById((long)i).get());
            cour.setModule(moduleRepository.findById((long)i).get());
            courRepository.save(cour);
        }
    }
}
