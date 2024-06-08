package com.spring_GestSchool.spring_GestSchool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnAuthorizeException extends RuntimeException  {
    private String message;

}
