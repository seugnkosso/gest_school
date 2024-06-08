package com.spring_GestSchool.spring_GestSchool.security.data.repositories;


import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepositories extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String rolename);
}
