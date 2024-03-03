package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
@AutoConfigureTestEntityManager
class ProyectoRepositoryDataTest {
    @Autowired
    private ProyectoRepositoryData repoProyecto;

    private static final Logger logger = LoggerFactory.getLogger(TareaRepositoryDataTest.class);

    @Autowired
    private TestEntityManager em;

    @Test
    void listarProyectos() {
        // given SQL Inserts


        // when
        List<Proyecto> proyectoList = repoProyecto.findAll();
        logger.info("Proyectos:" + proyectoList);

        // then
        assertThat(proyectoList.size())
                .isGreaterThan(0);
        assertNotNull(proyectoList);
    }

    @Test
    void listarProyectosporIDcuandoExiste() {
        // given SQL Inserts
        Long indicadorSolicitado = 1L;


        // when
        Optional<Proyecto> op = repoProyecto.findById(indicadorSolicitado);
        Proyecto proyecto = (Proyecto) op.get();

        logger.info("Proyectos:" + proyecto);

        // then
        assertEquals(proyecto.getId(),indicadorSolicitado);
        assertNotNull(proyecto);
    }

    @Test
    void listarProyectosporIDcuandoInexistente() {
        // given SQL Inserts
        Long indicadorSolicitado = 100L;


        // when
        Optional<Proyecto> op = repoProyecto.findById(indicadorSolicitado);


        // then
        assertTrue(op.isEmpty());
    }

}