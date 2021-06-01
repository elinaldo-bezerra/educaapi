package com.educacao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@SpringBootApplication 
@EntityScan(basePackages = {"com.educa.educaapi.model"})
@EnableJpaRepositories(basePackages = {"com.educa.educaapi.repository"})

public class EducaapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducaapiApplication.class, args);

    }

    @Bean
    public WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*");               
            }
        };
    }

}
