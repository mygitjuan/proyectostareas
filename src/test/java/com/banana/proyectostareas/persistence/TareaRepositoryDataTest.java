package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.config.SpringConfig;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.model.Proyecto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class TareaRepositoryDataTest {

    @Autowired
    TareaRepositoryData repoTarea;

    @Test
    @Transactional
    void getById() throws SQLException{
        Optional<Tarea> op = repoTarea.findById(1L);
        Tarea aTarea = (Tarea) op.get();
        //Tarea aTarea = repoTarea.
        System.out.println(aTarea);
        assertEquals(aTarea.getId(), 1L);
        assertNotNull(aTarea);
    }
}