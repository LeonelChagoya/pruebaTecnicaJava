package com.java.domain.repository;

import com.java.domain.model.CatalogoLibros;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository {
    List<CatalogoLibros> findAll(int offset, int limit);
    Optional<CatalogoLibros> findById(Long id);
    void save(CatalogoLibros libro);
    void update(CatalogoLibros libro);
    void delete(Long id);
}
