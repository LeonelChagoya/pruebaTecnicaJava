package com.java.application.service;


import com.java.domain.model.InventarioLibros;
import com.java.domain.repository.InventarioLibrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioLibrosService {

    private final InventarioLibrosRepository inventarioLibrosRepository;

    public InventarioLibrosService(InventarioLibrosRepository inventarioLibrosRepository) {
        this.inventarioLibrosRepository = inventarioLibrosRepository;
    }
    public List<InventarioLibros> findAll(int page, int size) {
        int offset = page * size;
        return inventarioLibrosRepository.findAll(offset, size);
    }

    public void save(InventarioLibros inventarioLibros) {
        inventarioLibrosRepository.save(inventarioLibros);
    }
    public Optional<InventarioLibros> chowInventario(Long id) {
        return  inventarioLibrosRepository.findById(id);
    }
}
