package com.translationservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.translationservice.application")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
