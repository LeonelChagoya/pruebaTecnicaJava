package com.java.infrastructure.persistence.repository;

import com.java.domain.model.CatalogoLibros;
import com.java.domain.repository.LibrosRepository;
import com.java.infrastructure.persistence.mapper.LibrosMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class LibrosRepositoryImpl  implements LibrosRepository {
    private  final LibrosMapper librosMapper;
    public LibrosRepositoryImpl(LibrosMapper librosMapper) {
        this.librosMapper = librosMapper;
    }

    @Override
    public List<CatalogoLibros> findAll(int offset, int limit) {
     return librosMapper.findAll(offset, limit);
    }

    @Override
    public Optional<CatalogoLibros> findById(Long id) {
        return Optional.ofNullable(librosMapper.findById(id));
    }

    @Override
    public void save(CatalogoLibros libro) {
        librosMapper.save(libro);
    }

    @Override
    public void update(CatalogoLibros libro) {
        librosMapper.update(libro);

    }

    @Override
    public void delete(Long id) {
        librosMapper.delete(id);
    }


}
