package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import com.spring_GestSchool.spring_GestSchool.data.entities.Etudiant;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AbsenceRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ClasseRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.EtudiantRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(6)
public class EtudiantFixture implements CommandLineRunner {
    private final EtudiantRepository etudiantRepository;
    private final AbsenceRepository absenceRepository;
    private final ClasseRepository classeRepository;
    private final InscriptionRepository inscriptionRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Etudiant etudiant = new Etudiant();
            etudiant.setMatricule("matricule"+i);
            etudiant.setNomComplet("etudiant"+i);
            etudiant.setTelephone("e77233494"+i);
            etudiant.setEmail("etudiant"+i+"@gmail.com");
            etudiant.setPassword(passwordEncoder.encode("passer"));
            etudiant.setUsername("etudiant"+i);;
            etudiant.setClasse(classeRepository.findById((long)i).get());
            etudiantRepository.save(etudiant);
            securityService.addRoleToUser(etudiant.getUsername(),"Etudiant");
        }
    }
}
