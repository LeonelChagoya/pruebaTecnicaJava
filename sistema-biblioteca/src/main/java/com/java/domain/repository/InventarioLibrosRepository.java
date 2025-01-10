package com.java.domain.repository;

import com.java.domain.model.InventarioLibros;


import java.util.List;
import java.util.Optional;

public interface InventarioLibrosRepository {
    List<InventarioLibros> findAll(int offset, int limit);
    Optional<InventarioLibros> findById(Long id);
    void save(InventarioLibros inventarioLibros);
    void delete(InventarioLibros inventarioLibros);
    void update(InventarioLibros inventarioLibros);
}
