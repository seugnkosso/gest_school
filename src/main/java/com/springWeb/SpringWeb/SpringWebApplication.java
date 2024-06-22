package com.springWeb.SpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.springWeb.SpringWeb",
		"com.spring_GestSchool.spring_GestSchool",
})
public class SpringWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
