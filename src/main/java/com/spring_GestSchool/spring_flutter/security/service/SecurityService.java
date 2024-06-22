package com.spring_GestSchool.spring_flutter.security.service;


import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppRole;
import com.spring_GestSchool.spring_GestSchool.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUserName(String userName);

    AppUser saveUser(String username, String password);

    AppRole saveRole(String roleName);

    void addRoleToUser(String userName, String roleName);

    void removeRoleToUser(String userName, String roleName);
}
