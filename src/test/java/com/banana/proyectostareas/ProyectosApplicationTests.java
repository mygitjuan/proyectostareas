package com.banana.proyectostareas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
@EnableAutoConfiguration
@AutoConfigureTestEntityManager*/
@SpringBootTest
class ProyectosApplicationTests {

	@Test
	void contextLoads() {
	}

}
