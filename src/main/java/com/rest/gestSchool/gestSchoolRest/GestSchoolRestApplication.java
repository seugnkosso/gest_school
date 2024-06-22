package com.rest.gestSchool.gestSchoolRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.rest.gestSchool.gestSchoolRest",
				"com.spring_GestSchool.spring_GestSchool",
		}
)
public class GestSchoolRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestSchoolRestApplication.class, args);
	}
}
