package com.banana.proyectostareas.model;

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
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "proyecto")
@Schema(name = "proyecto", description = "Modelo proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Min(1)
    @Schema(name = "ProyectoID", example = "1", required = false)
    private Long id;
    @Column(name="nombre")
    @Size(min = 3, max = 20)
    @Schema(name = "nombre", example = "UML", required = true)
    private String nombre;
    @Column(name="fecha_creacion")
    @DateTimeFormat
    @NotNull
    @Schema(name = "fechaCreacion", example = "2024-01-31", required = true)
    private LocalDate fechaCreacion;
}
