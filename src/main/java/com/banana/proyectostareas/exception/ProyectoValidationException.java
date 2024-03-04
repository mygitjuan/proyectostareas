package com.banana.proyectostareas.exception;

public class ProyectoValidationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProyectoValidationException(String message) {
        super(message);
    }
}