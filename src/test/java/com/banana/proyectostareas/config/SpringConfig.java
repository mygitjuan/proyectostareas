package com.banana.proyectostareas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = {"com.banana.proyectostareas.persistence", "com.banana.proyectostareas.service"})
@EntityScan("com.banana.proyectostareas.model")
@EnableJpaRepositories(basePackages = {"com.banana.proyectostareas.persistence"})
public class SpringConfig {

}
