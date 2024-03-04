package com.banana.proyectostareas.service;

import com.banana.proyectostareas.model.Proyecto;

public interface IServicioProyecto {
    public Proyecto crearProyecto(Proyecto proyecto, Long indTarea);
}
