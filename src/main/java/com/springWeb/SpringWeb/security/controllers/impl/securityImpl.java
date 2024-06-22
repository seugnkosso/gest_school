package com.springWeb.SpringWeb.security.controllers.impl;

import com.springWeb.SpringWeb.security.controllers.security;
import com.springWeb.SpringWeb.security.services.SecurityService;
import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class securityImpl implements security {
    private final SecurityService securityService;
    @Override
    public String login(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            if (userDetails.getAuthorities()
                    .stream()
                    .anyMatch(role -> role.getAuthority().compareTo("Attacher") == 0)
            ) {
                return "redirect:/professeurs";
            }
        }
        return "/security/login";
    }

    @Override
    public String login() {
        return "redirect:/login";
    }
}
