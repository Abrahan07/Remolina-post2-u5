package com.universidad.patrones.mapper;

import com.universidad.patrones.dto.LibroRequestDTO;
import com.universidad.patrones.dto.LibroResponseDTO;
import com.universidad.patrones.model.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroResponseDTO toResponse(Libro libro) {
        return new LibroResponseDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getAnioPublicacion(),
                libro.getCategoria()
        );
    }

    public Libro toEntity(LibroRequestDTO dto) {
        return new Libro(
                null,
                dto.getTitulo(),
                dto.getAutor(),
                dto.getIsbn(),
                dto.getAnioPublicacion(),
                dto.getCategoria()
        );
    }
}