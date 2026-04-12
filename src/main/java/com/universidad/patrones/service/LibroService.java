package com.universidad.patrones.service;

import com.universidad.patrones.model.Libro;
import com.universidad.patrones.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class LibroService {

    private final LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public List<Libro> findAll() {
        return repo.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return repo.findById(id);
    }

    public Libro save(Libro libro) {
        if (repo.existsByIsbn(libro.getIsbn()))
            throw new IllegalArgumentException("Ya existe un libro con ISBN: " + libro.getIsbn());
        return repo.save(libro);
    }

    public Libro update(Long id, Libro datos) {
        Libro existente = repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro no encontrado: " + id));
        existente.setTitulo(datos.getTitulo());
        existente.setAutor(datos.getAutor());
        existente.setCategoria(datos.getCategoria());
        existente.setAnioPublicacion(datos.getAnioPublicacion());
        return repo.save(existente);
    }

    public void deleteById(Long id) {
        if (!repo.existsById(id))
            throw new NoSuchElementException("Libro no encontrado: " + id);
        repo.deleteById(id);
    }

    public List<Libro> buscarPorPalabra(String palabra) {
        return repo.buscarPorPalabra(palabra);
    }
}