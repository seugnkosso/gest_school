package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.Inscription;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AnneeScolaireRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Order(11)
public class InscriptionFixture implements CommandLineRunner {
    private final InscriptionRepository inscriptionRepository;
    private final EtudiantRepository etudiantRepository;
    private final AnneeScolaireRepository anneeScolaireRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Inscription inscrit = new Inscription();
            inscrit.setDate(new Date());
            if (i % 2 == 0) {
                inscrit.setAnneeScolaire(anneeScolaireRepository.findById((long) 1).get());
            } else {
                inscrit.setAnneeScolaire(anneeScolaireRepository.findById((long) 2).get());
            }
            inscrit.setEtudiant(etudiantRepository.findById((long)i+57).get());
            inscriptionRepository.save(inscrit);
        }
    }
}
