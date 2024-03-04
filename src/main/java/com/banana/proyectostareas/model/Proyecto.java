package com.banana.proyectostareas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "proyectos")
@Schema(name = "proyecto", description = "Modelo proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "ProyectoID", example = "1", required = false)
    private Long id;

    @Size(min = 3, max = 20)
    @Schema(name = "nombre", example = "UML", required = true)
    private String nombre;

    @Column(name="fecha_creacion")
    @DateTimeFormat
    @NotNull
    @Schema(name = "fechaCreacion", example = "2024-01-31", required = true)
    private LocalDate fechaCreacion;

    @Column(name="tareas")
    @Min(1)
    @Schema(name = "tareas", example = "1", required = true)
    private Integer tareas;

    @JsonIgnore
    @Schema(name = "proyecto_id", example = "", required = false)
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "proyecto")
    private List<Tarea> tareasList = new ArrayList<>();
}
