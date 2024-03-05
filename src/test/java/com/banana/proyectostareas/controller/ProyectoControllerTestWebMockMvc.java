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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

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

        List<Proyecto> products = Arrays.asList(
                new Proyecto(1L, "Fake proyecto",fecha ,1,null)
        );

        Mockito.when(service.getProductsByText("Fake"))
                .thenReturn(products);

        Mockito.when(repository.findByNombreContaining("Fake"))
                .thenReturn(products);

        Mockito.when(repository.findAll())
                .thenReturn(products);

        Mockito.when(repository.save(Mockito.any(Proyecto.class)))
                .thenAnswer(elem -> {
                    Proyecto proy = (Proyecto) elem.getArguments()[0];
                    proy.setId(100L);
                    return proy;
                });
    }


    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProyectoTareaService service;

    @Autowired
    private ProyectoRepositoryData repository;


    @Test
    @Order(1)
    @Transactional
    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
        Proyecto nuevoProy = new Proyecto(1L, "Fake proyecto", LocalDate.now(),1,null);

        List<Proyecto> allProducts = Arrays.asList(nuevoProy);

        given(repository.findAll()).willReturn(allProducts);

        mvc.perform(get("/proyecto")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is(nuevoProy.getNombre())));
    }
}