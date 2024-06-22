package com.spring_GestSchool.spring_flutter.security.data.fixtures;

import com.spring_GestSchool.spring_flutter.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

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
