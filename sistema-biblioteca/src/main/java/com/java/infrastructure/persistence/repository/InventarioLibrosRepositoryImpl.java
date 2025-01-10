package com.java.infrastructure.persistence.repository;

import com.java.domain.model.InventarioLibros;
import com.java.domain.repository.InventarioLibrosRepository;
import com.java.infrastructure.persistence.mapper.InventarioLibrosMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class InventarioLibrosRepositoryImpl implements InventarioLibrosRepository {
    private final InventarioLibrosMapper inventarioLibrosMapper;

    public InventarioLibrosRepositoryImpl(InventarioLibrosMapper inventarioLibrosMapper) {
        this.inventarioLibrosMapper = inventarioLibrosMapper;
    }

    @Override
    public List<InventarioLibros> findAll(int offset, int limit) {
        return inventarioLibrosMapper.findAll(offset, limit);
    }

    @Override
    public Optional<InventarioLibros> findById(Long id) {
        return Optional.ofNullable(inventarioLibrosMapper.findById(id));
    }

    @Override
    public void save(InventarioLibros inventarioLibros) {
        inventarioLibrosMapper.save(inventarioLibros);
    }

    @Override
    public void delete(InventarioLibros inventarioLibros) {

    }

    @Override
    public void update(InventarioLibros inventarioLibros) {

    }
}
