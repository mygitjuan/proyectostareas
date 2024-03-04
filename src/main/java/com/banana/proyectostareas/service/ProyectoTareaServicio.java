package com.banana.proyectostareas.service;

import com.banana.proyectostareas.exception.ProyectoNotfoundException;
import com.banana.proyectostareas.exception.TareaNotfoundException;
import com.banana.proyectostareas.model.Proyecto;
import com.banana.proyectostareas.model.Tarea;
import com.banana.proyectostareas.persistence.ProyectoRepositoryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProyectoTareaServicio implements ProyectoTareaService{

    @Autowired
    ProyectoRepositoryData repoProyecto;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) throws RuntimeException {
        return null;
    }

    @Override
    public Proyecto anadeTareaAProyecto(Long idProyecto, Tarea tarea) throws ProyectoNotfoundException, RuntimeException {
        return null;
    }

    @Override
    public List<Proyecto> obtenerProyectos() throws ProyectoNotfoundException, RuntimeException {
        List<Proyecto> proyectoList = null;

        try {
            proyectoList = repoProyecto.findAll();
        } catch (ProyectoNotfoundException e) {
            e.printStackTrace();
            throw new ProyectoNotfoundException("Error al obtener lista de usuarios: "  + e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ProyectoNotfoundException("Error al obtener lista de usuarios: "  + e.getMessage());
        }

        return proyectoList;
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
