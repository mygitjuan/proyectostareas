package com.banana.proyectostareas.controller;

import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import com.banana.proyectostareas.service.ProyectoTareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProyectoControllerTestWebMockMvc {

    @BeforeEach
    public void setUp() {
        LocalDate fecha = LocalDate.now();

        List<Proyecto> proyectos = Arrays.asList(
                new Proyecto(1L, "Fake proyecto",fecha ,1,null)
        );

        Mockito.when(service.getProyectosByText("Fake"))
                .thenReturn(proyectos);

        Mockito.when(repository.findByNombreContaining("Fake"))
                .thenReturn(proyectos);

        Mockito.when(repository.findAll())
                .thenReturn(proyectos);

    }


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProyectoTareaService service;

    @MockBean
    private ProyectoRepositoryData repository;


    @Test
    @Order(1)
    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
        Proyecto nuevoProy = new Proyecto(1L, "Fake proyecto", LocalDate.now(),1,null);

        List<Proyecto> allProyectos = Arrays.asList(nuevoProy);

        given(repository.findAll()).willReturn(allProyectos);

        mvc.perform(get("/proyectos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is(nuevoProy.getNombre())));
    }

    @Test
    @Order(2)
    public void givenProducts_whenGetProducts_thenStatus404() throws Exception {
        Proyecto nuevoProy = new Proyecto(1L, "Fake proyecto", LocalDate.now(),1,null);

        List<Proyecto> allProyectos = Arrays.asList(nuevoProy);

        given(repository.findAll()).willReturn(allProyectos);

        mvc.perform(get("/noexisto")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}