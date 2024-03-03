package com.banana.proyectostareas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
//@EntityScan("com.banana.models")
@EnableJpaRepositories(basePackages = {"com.banana.proyectostareas.persistence"}, entityManagerFactoryRef = "aModelEmf")
public class SpringConfig {

}
