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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tareas")
@Schema(name = "tarea", description = "Modelo tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Min(1)
    @Schema(name = "TareaID", example = "1L", required = false)
    private Long id;

    @Size(min = 3, max = 20)
    @Schema(name = "descripcion", example = "UML", required = true)
    private String descripcion;

    @Column(name="fecha_limite")
    @DateTimeFormat
    @NotNull
    @Schema(name = "fechaLimite", example = "2024-01-31", required = true)
    private LocalDate fechaLimite;

    @Min(1)
    @Schema(name = "orden", example = "1", required = true)
    private Integer orden;

    @NotNull
    @Schema(name = "completada", example = "true", required = true)
    private boolean completada;


    @ToString.Exclude
    @JsonIgnore
    @Schema(name = "proyecto_id", example = "", required = false)
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
}
