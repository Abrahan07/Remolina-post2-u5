package com.universidad.patrones.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio")
    private String isbn;

    @Min(1800) @Max(2100)
    private Integer anioPublicacion;

    private String categoria;
}