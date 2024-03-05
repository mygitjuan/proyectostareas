package com.banana.proyectostareas.controller;

import com.banana.proyectostareas.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProyectoControllerTestMockMvc {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProyectoRepositoryData repository;


    @Test
    @Order(1)
    @Transactional
    public void givenProducts_whenGetProducts_thenStatus200() throws Exception {
        Proyecto nuevoProy = new Proyecto(null, "ReskillIA", LocalDate.now(),1,null);
        repository.save(nuevoProy);

        mvc.perform(get("/proyectos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].name", hasItem("ReskillIA")));
    }
}