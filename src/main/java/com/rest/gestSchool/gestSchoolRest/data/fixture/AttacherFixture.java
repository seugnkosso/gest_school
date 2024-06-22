package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import com.spring_GestSchool.spring_GestSchool.data.entities.Attacher;
import com.spring_GestSchool.spring_GestSchool.data.repositories.AttacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class AttacherFixture implements CommandLineRunner {
    private final AttacheRepository attacheRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            Attacher attacher = new Attacher();
            attacher.setNomComplet("attacher"+i);
            attacher.setEmail("email"+i+"@gmail.com");
            attacher.setPassword(passwordEncoder.encode("passer"));
            attacher.setTelephone("77233494"+i);
            attacher.setUsername("attacher"+i);
            attacheRepository.save(attacher);
            securityService.addRoleToUser(attacher.getUsername(),"Attacher");
        }
    }
}
