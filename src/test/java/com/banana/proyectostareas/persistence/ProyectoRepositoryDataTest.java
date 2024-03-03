package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.config.SpringConfig;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.model.Proyecto;
import net.minidev.json.JSONUtil;
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
class ProyectoRepositoryDataTest {
    @Autowired
    ProyectoRepositoryData repoProyecto;

    @Test
    @Transactional
    void getById() throws SQLException {
        Optional<Proyecto> opt = repoProyecto.findById(1L);
        Proyecto aProyecto = (Proyecto) opt.get();
        System.out.println(aProyecto);
        assertEquals(aProyecto.getId(), 1L);
        assertNotNull(aProyecto);
    }



}