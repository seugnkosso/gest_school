package com.spring_GestSchool.spring_flutter.security.data.fixtures;

import com.spring_GestSchool.spring_flutter.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

//@Component
@Order(1)
@RequiredArgsConstructor
public class AppRoleFixture implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        securityService.saveRole("Admin");
        securityService.saveRole("Client");
    }
}
