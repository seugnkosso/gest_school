package com.rest.gestSchool.gestSchoolRest.security.data.fixtures;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@RequiredArgsConstructor
public class AppRoleFixture implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        securityService.saveRole("Professeur");
        securityService.saveRole("Etudiant");
        securityService.saveRole("RP");
        securityService.saveRole("Attacher");
    }
}
