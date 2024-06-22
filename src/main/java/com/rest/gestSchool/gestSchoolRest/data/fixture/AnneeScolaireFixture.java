package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.spring_GestSchool.spring_GestSchool.data.entities.AnneeScollaire;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AnneeScolaireRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class AnneeScolaireFixture implements CommandLineRunner {
    private final AnneeScolaireRepository anneeScolaireRepository;
    private final ClasseRepository classeRepository;
    private final InscriptionRepository inscriptionRepository;
    private final CourRepository courRepository;

    @Override
    public void run(String... args) throws Exception {
        AnneeScollaire anneeScollaire1 = new AnneeScollaire();
        anneeScollaire1.setLibelle("2023-2024");
        anneeScolaireRepository.save(anneeScollaire1);
        AnneeScollaire anneeScollaire2 = new AnneeScollaire();
        anneeScollaire2.setLibelle("2022-2023");
        anneeScolaireRepository.save(anneeScollaire2);
    }
}
