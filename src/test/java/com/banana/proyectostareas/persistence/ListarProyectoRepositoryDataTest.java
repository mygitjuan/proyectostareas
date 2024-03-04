package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ListarProyectoRepositoryDataTest {
    @Autowired
    private ProyectoRepositoryData repoProyecto;

    @Autowired
    private TareaRepositoryData repoTarea;
    private static final Logger logger = LoggerFactory.getLogger(ListarTareaRepositoryDataTest.class);

    @Autowired
    private TestEntityManager em;

    @Test
    void listarProyectos() throws ProyectoNotfoundException {
        // given
        Tarea tarea = new Tarea(null,"FAKE", LocalDate.now(),6,FALSE,null);
        em.persist(tarea);
        em.remove(tarea); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        em.flush();

        // when
        List<Proyecto> proyectoList = repoProyecto.findAll();
        logger.info("Proyectos:" + proyectoList);

        // then
        assertThat(proyectoList.size())
                .isGreaterThan(0);
        assertNotNull(proyectoList);
    }

    @Test
    void listarProyectosporIDcuandoExiste() throws ProyectoNotfoundException{
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
    void listarProyectosporIDcuandoInexistente() throws ProyectoNotfoundException{
        // given SQL Inserts
        Long indicadorSolicitado = 100L;


        // when
        Optional<Proyecto> op = repoProyecto.findById(indicadorSolicitado);


        // then
        assertTrue(op.isEmpty());
    }


}