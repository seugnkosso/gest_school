package com.spring_GestSchool.spring_flutter.security.controllers.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
