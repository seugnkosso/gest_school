package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Classe;
import com.spring_GestSchool.spring_GestSchool.data.entities.Cour;
import com.spring_GestSchool.spring_GestSchool.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(6)
public class ClasseFixture implements CommandLineRunner {
    private final AttacheRepository attacheRepository;
    private final EtudiantRepository etudiantRepository;
    private final FiliereRepository filiereRepository;
    private final CourRepository courRepository;
    private final NiveauRepository niveauRepository;
    private final ClasseRepository classeRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Classe classe = new Classe();
            classe.setLibelle("classe" + i);
            classe.setAttacher(attacheRepository.findById((long)i).get());
            classe.setFiliere(filiereRepository.findById((long)i).get());
            classe.setNiveau(niveauRepository.findById((long)i).get());
            List<Cour> cours = new ArrayList<Cour>();
            cours.add(courRepository.findById((long) i).get());
            classe.setListeCour(cours);
            if (i % 2 == 0) {
                classe.setAnneeScolaire(anneeScolaireRepository.findById((long) 1).get());
            } else {
                classe.setAnneeScolaire(anneeScolaireRepository.findById((long) 2).get());
            }
            classeRepository.save(classe);
        }
    }
}
