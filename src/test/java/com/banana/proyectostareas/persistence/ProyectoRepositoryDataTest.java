package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import org.hibernate.PersistentObjectException;
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
class ProyectoRepositoryDataTest {
    @Autowired
    private ProyectoRepositoryData repoProyecto;

    @Autowired
    private TareaRepositoryData repoTarea;
    private static final Logger logger = LoggerFactory.getLogger(TareaRepositoryDataTest.class);

    @Autowired
    private TestEntityManager em;

    @Test
    void soloProyecto() throws ProyectoNotfoundException{
        Proyecto proyecto = new Proyecto(null,"ReskillRPG",LocalDate.now(),6,null);

        //then
        em.persist(proyecto);
        em.flush();
        //when
        logger.info("Proyecto:" + proyecto);
        assertNotNull(proyecto);
        assertTrue(proyecto.getId() > 0);

        Proyecto proyectoExtraer = em.find(Proyecto.class, proyecto.getId());
        logger.info("Proyecto Extraer:" + proyectoExtraer);
        assertNotNull(proyectoExtraer);
        assertEquals(proyectoExtraer.getId(), proyecto.getId());

    }

    @Test
    void crearProyectosDevuelveOK() throws ProyectoNotfoundException {
        //given
        Tarea tarea = new Tarea(null,"FAKE", LocalDate.now(),6,FALSE,null);
        em.persist(tarea);
        em.remove(tarea); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        em.flush();

        Long indTarea = 1L;

        //Buscamos la tarea
        Optional<Tarea> tareaOpc = repoTarea.findById(indTarea);
        assertNotNull(tareaOpc);
        logger.info("TareaOPC:" + tareaOpc);

        //Como causa problemas al moverla directamente a List<Tarea>, hago un pase intermedio a Tarea.
        Tarea unaTarea = (Tarea) tareaOpc.get();
        assertNotNull(unaTarea);
        logger.info("unaTarea:" + unaTarea);

        //Informamos el área List que insertaremos en la entidad
        List<Tarea> tareaList = new ArrayList<>();
        tareaList.add(unaTarea);
        logger.info("Tarea:" + tareaList);
        assertNotNull(tareaList);


        Proyecto proyecto = new Proyecto(null,"ReskillRPG",LocalDate.now(),6,tareaList);

        //then
        em.persist(proyecto);
        em.flush();
        //when
        logger.info("Proyecto:" + proyecto);
        assertNotNull(proyecto);
        assertTrue(proyecto.getId() > 0);

        Proyecto proyectoExtraer = em.find(Proyecto.class, proyecto.getId());
        logger.info("Proyecto Extraer:" + proyectoExtraer);
        assertNotNull(proyectoExtraer);
        assertEquals(proyectoExtraer.getId(), proyecto.getId());

    }

    @Test
    void crearProyectosDevuelveIncidencia() throws ProyectoNotfoundException {
        //given
        Tarea tarea = new Tarea(null,"FAKE", LocalDate.now(),6,FALSE,null);
        em.persist(tarea);
        em.remove(tarea); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        em.flush();

        Long indTarea = 1L;

        //Buscamos la tarea
        Optional<Tarea> tareaOpc = repoTarea.findById(indTarea);
        assertNotNull(tareaOpc);
        logger.info("TareaOPC:" + tareaOpc);

        //Como causa problemas al moverla directamente a List<Tarea>, hago un pase intermedio a Tarea.
        Tarea unaTarea = (Tarea) tareaOpc.get();
        assertNotNull(unaTarea);
        logger.info("unaTarea:" + unaTarea);

        //Informamos el área List que insertaremos en la entidad
        List<Tarea> tareaList = new ArrayList<>();
        tareaList.add(unaTarea);
        logger.info("Tarea:" + tareaList);
        assertNotNull(tareaList);
        //then
        Proyecto proyecto = new Proyecto(1L,"Duplicado",LocalDate.now(),6,tareaList);

        //when
        assertThrows(Exception.class, () -> {
                    em.persist(proyecto);
                }
        );

    }

    @Test
    void findAll() throws ProyectoNotfoundException{
        // given SQL Inserts
        Proyecto proyecto = new Proyecto(null,"ReskillRPG",LocalDate.now(),6,null);

        //then
        em.persist(proyecto);
        em.remove(proyecto);
        em.flush();

        // when
        List<Proyecto> proyectoList = repoProyecto.findAll();
        logger.info("Proyectos:" + proyectoList);

        assertThat(proyectoList.size())
                .isGreaterThan(0);

        assertNotNull(proyectoList);
    }


}