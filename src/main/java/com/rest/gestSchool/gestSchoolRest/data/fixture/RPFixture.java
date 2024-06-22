package com.rest.gestSchool.gestSchoolRest.data.fixture;

import com.rest.gestSchool.gestSchoolRest.security.service.SecurityService;
import com.spring_GestSchool.spring_GestSchool.data.entities.RP;
import com.spring_GestSchool.spring_GestSchool.data.repositories.RPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(4)
public class RPFixture implements CommandLineRunner {
    private final RPRepository rpRepository;
    private final SecurityService securityService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i < 20; i++) {
            RP rp = new RP();
            rp.setNomComplet("Rp"+i);
            rp.setTelephone("r77233494"+i);
            rp.setEmail("Rp"+i+"@gmail.com");
            rp.setPassword(passwordEncoder.encode("passer"));
            rp.setUsername("RP"+i);
            rpRepository.save(rp);
            securityService.addRoleToUser(rp.getUsername(),"RP");
        }
    }
}
