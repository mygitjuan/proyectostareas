package com.banana.proyectostareas;

import com.banana.proyectostareas.config.SpringConfig;
import com.banana.proyectostareas.config._SpringConfig_;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
@SpringBootTest
class ProyectosApplicationTests {

	@Test
	void contextLoads() {
	}

}
