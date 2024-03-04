package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.exception.TareaNotfoundException;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.persistence")
//@EnableAutoConfiguration
@AutoConfigureTestEntityManager
class ListarTareaRepositoryDataTest {
    private static final Logger logger = LoggerFactory.getLogger(ListarTareaRepositoryDataTest.class);

    @Autowired
    public TareaRepositoryData repoTarea;

    @Autowired
    private TestEntityManager em;

    @Test
    void findAll() throws TareaNotfoundException {
        // given SQL Inserts


        // when
        List<Tarea> tareaList = repoTarea.findAll();
        logger.info("Tareas:" + tareaList);

        // then
        assertThat(tareaList.size())
                .isGreaterThan(0);

        assertNotNull(tareaList);
    }

}