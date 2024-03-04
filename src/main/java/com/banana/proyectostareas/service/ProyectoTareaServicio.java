package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.exception.TareaNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import com.banana.proyectostareas.persistence.TareaJPARepository;
import com.banana.proyectostareas.persistence.TareaRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class ProyectoTareaServicio implements ProyectoTareaService{

    @Autowired
    ProyectoRepositoryData repoProyecto;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws ProyectoNotfoundException, RuntimeException {

        try {
            repoProyecto.save(proyecto);
        } catch (ProyectoNotfoundException e) {
            e.printStackTrace();
            throw new ProyectoNotfoundException("Error en la creación: " + e.getMessage());
        }   catch (RuntimeException e) {
            e.printStackTrace();
            throw new ProyectoNotfoundException("Error en la creación: " + e.getMessage());
        }

        return proyecto;
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Tarea> obtenerTareasDelProyecto(Long idProyecto) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public Tarea marcarTareaHecha(Long idTarea) throws TareaNotfoundException, RuntimeException {
        return null;
    }
}
