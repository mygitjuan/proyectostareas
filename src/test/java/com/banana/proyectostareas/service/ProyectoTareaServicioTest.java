package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = {"com.banana.proyectostareas.service","com.banana.proyectostareas.persistence"})
@DataJpaTest
@AutoConfigureTestEntityManager
class ProyectoTareaServicioTest {
    @Autowired
    private ProyectoTareaService proyectoTareaService;

    private static final Logger logger = LoggerFactory.getLogger(ProyectoTareaServicioTest.class);

    @Autowired
    private TestEntityManager em;

    @Test
    void obtenerProyectosValido() {

        List<Proyecto> proyectoList = null;

        try {
            proyectoList = proyectoTareaService.obtenerProyectos();
        }  catch (ProyectoNotfoundException e) {
            throw new ProyectoNotfoundException("Error listar proyectos: " + e.getMessage());
        }

        assertThat(proyectoList.size(),greaterThan(0));
        assertNotNull(proyectoList);

    }

    @Test
    void obtenerProyectosInvalido() {
        proyectoTareaService.obtenerProyectos();
        List<Proyecto> proyectoList = null;

        try {
            proyectoList = proyectoTareaService.obtenerProyectos();
        }  catch (ProyectoNotfoundException e) {
            throw new ProyectoNotfoundException("Error listar proyectos: " + e.getMessage());
        }

        assertEquals(proyectoList.size(),0);
        assertNull(proyectoList);

    }
}