package com.spring_GestSchool.spring_flutter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.spring_GestSchool.spring_flutter",
				"com.spring_GestSchool.spring_GestSchool",
		}
)
public class SpringFlutterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFlutterApplication.class, args);
	}

}
