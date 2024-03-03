package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProyectoRepositoryData extends JpaRepository<Proyecto, Long> {
}
