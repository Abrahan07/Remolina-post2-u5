package com.universidad.patrones.repository;

import com.universidad.patrones.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutorIgnoreCase(String autor);

    List<Libro> findByCategoria(String categoria);

    boolean existsByIsbn(String isbn);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:palabra%")
    List<Libro> buscarPorPalabra(@Param("palabra") String palabra);
}