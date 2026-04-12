package com.universidad.patrones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;

    @Column(unique = true)
    @NotBlank(message = "El ISBN no puede estar vacío")
    private String isbn;

    @Min(value = 1800, message = "El año debe ser válido")
    private Integer anioPublicacion;

    private String categoria;
}