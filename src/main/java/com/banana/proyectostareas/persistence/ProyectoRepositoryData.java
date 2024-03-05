package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProyectoRepositoryData extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByNameContaining(String name);
    @Query("select p from Proyecto p where p.name = ?1")
    Proyecto findByName(String name);
}
