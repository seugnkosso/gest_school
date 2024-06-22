package com.rest.gestSchool.gestSchoolRest.security.data.fixtures;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(2)
@RequiredArgsConstructor
public class AppUserFixture implements CommandLineRunner {
    private final SecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        securityService.saveUser("admin","passer");
        securityService.addRoleToUser("admin","Admin");
        securityService.addRoleToUser("admin","Client");
    }
}
