package com.spring_GestSchool.spring_GestSchool.security.data.repositories;

import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepositories extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
