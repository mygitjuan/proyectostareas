package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.exception.TareaNotfoundException;
import com.banana.proyectostareas.model.Tarea;
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
import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.junit.jupiter.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
//@EnableAutoConfiguration
@AutoConfigureTestEntityManager
class TareaRepositoryDataTest {
    private static final Logger logger = LoggerFactory.getLogger(TareaRepositoryDataTest.class);

    @Autowired
    private TareaRepositoryData repoTarea;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAll() throws TareaNotfoundException {
        // given SQL Inserts
        Tarea tarea = new Tarea(null,"FAKE", LocalDate.now(),6,FALSE,null);
        em.persist(tarea);
        em.remove(tarea); //quiero usar un Entity Manager, pero no quiero hacer el alta, solo quiero retornar datos
        em.flush();

        // when

        List<Tarea> tareaList = repoTarea.findAll();
        logger.info("Tareas:" + tareaList);

        // then
        assertThat(tareaList.size())
                .isGreaterThan(0);

        assertNotNull(tareaList);


        for (Tarea t:tareaList) {
            System.out.println(t);

        }
    }

}