package com.educa.educaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.educa.educaapi.model" })
@EnableJpaRepositories(basePackages = { "com.educa.educaapi.repository" })

public class EducaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducaapiApplication.class, args);
	}

}