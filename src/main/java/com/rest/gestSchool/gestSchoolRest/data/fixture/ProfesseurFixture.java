package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import com.spring_GestSchool.spring_GestSchool.data.entities.Professeur;
import com.spring_GestSchool.spring_GestSchool.data.repositories.CourRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.GradeRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.ProfesseurRepository;
import com.spring_GestSchool.spring_GestSchool.data.repositories.SpécialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class ProfesseurFixture implements CommandLineRunner {
    private final GradeRepository gradeRepository;
    private final SpécialiteRepository spécialiteRepository;
    private final CourRepository courRepository;
    private final ProfesseurRepository professeurRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Professeur professeur = new Professeur();
            professeur.setNomComplet("professeur"+i);
            professeur.setTelephone("p77233494"+i);
            professeur.setEmail("professeur"+i+"@gmail.com");
            professeur.setPassword(passwordEncoder.encode("passer"));
            professeur.setUsername("professeur" + i);
            professeur.setSpécialite(spécialiteRepository.findById((long)i).get());
            professeurRepository.save(professeur);
            securityService.addRoleToUser(professeur.getUsername(),"Professeur");
        }
    }
}
