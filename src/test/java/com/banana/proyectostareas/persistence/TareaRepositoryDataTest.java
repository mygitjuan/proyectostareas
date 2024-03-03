package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.config.SpringConfig;
import com.banana.proyectostareas.config._SpringConfig_;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

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
        /*Optional<Tarea> op = repoTarea.findById(1L);
        System.out.println("JEJEJE");
        Tarea aTarea = (Tarea) op.get();*/
        Tarea aTarea = repoTarea.getReferenceById(1L);
        //Tarea aTarea = repoTarea.
        System.out.println("JAJAJA");
        System.out.println(aTarea);
        assertEquals(aTarea.getId(), 1L);
        assertNotNull(aTarea);
    }
}