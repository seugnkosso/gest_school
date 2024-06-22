package com.springWeb.SpringWeb.security.data.fixtures;

import com.springWeb.SpringWeb.security.services.SecurityService;
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
