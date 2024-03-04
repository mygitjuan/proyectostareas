package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan("com.banana.proyectostareas.service")
@AutoConfigureTestEntityManager
class ProyectoTareaServicioTest {
    @Autowired
    private ProyectoTareaService proyectoTareaService;

    private static final Logger logger = LoggerFactory.getLogger(ProyectoTareaServicioTest.class);
    @Test
    void crearProyecto() throws  ProyectoNotfoundException{
        Proyecto proyecto = new Proyecto(null,"VideoGames", LocalDate.now(),6,null);

        try {
            proyectoTareaService.crearProyecto(proyecto);
        }  catch (ProyectoNotfoundException e) {
            throw new ProyectoNotfoundException("Error listar proyectos: " + e.getMessage());
        }

        assertThat(proyecto.getId(),greaterThan(0L));
        assertNotNull(proyecto);
        List<Proyecto> proyectoList = proyectoTareaService.obtenerProyectos();
        assertNotNull(proyectoList);
        logger.info("Proyectos:" + proyectoList.toString());
    }

    @Test
    void crearProyectoInvalido() throws  ProyectoNotfoundException{
        Proyecto proyecto = new Proyecto(null,"VideoGames", LocalDate.now(),6,null);

        assertThrows(Exception.class, () -> {
            proyecto.setNombre("XX");
            proyectoTareaService.crearProyecto(proyecto);
                }
        );

    }


}