package com.banana.proyectostareas.persistence;

import com.banana.proyectostareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TareaRepositoryData extends JpaRepository<Tarea,Long>{

}
