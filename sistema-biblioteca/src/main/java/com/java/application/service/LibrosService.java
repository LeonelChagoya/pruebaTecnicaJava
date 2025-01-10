package com.java.application.service;


import com.java.domain.model.CatalogoLibros;
import com.java.domain.repository.LibrosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class LibrosService {
    final private LibrosRepository librosRepository;

    public LibrosService(LibrosRepository librosRepository) {
        this.librosRepository = librosRepository;
    }

    public List<CatalogoLibros> findAll(int page, int size) {
        int offset = page * size;
        return librosRepository.findAll(offset, size);
    }

    public void save(CatalogoLibros libro) {
        librosRepository.save(libro);
    }
    public Optional<CatalogoLibros> chowLibro(Long id) {
        return  librosRepository.findById(id);
    }
    public void update(Long id, CatalogoLibros libro) {
        libro.setId(id);
        librosRepository.update(libro);
    }

    public void delete(Long id) {
        librosRepository.delete(id);
    }
}
