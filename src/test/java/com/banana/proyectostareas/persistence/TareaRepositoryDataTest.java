package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.config.SpringConfig;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
@EnableAutoConfiguration
class TareaRepositoryDataTest {

    TareaRepositoryData repoTarea;

    @Test
    void getById() throws SQLException{
        Optional

        Tarea aTarea = repoTarea.findById(1L);
        System.out.println(aTarea);
        assertEquals(aTarea.getId(), 1L);
        assertNotNull(aTarea);
    }
}