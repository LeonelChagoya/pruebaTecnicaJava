package com.java.infrastructure.persistence.repository;

import com.java.domain.model.Prestamos;
import com.java.domain.repository.PrestamosLibrosRepository;
import com.java.infrastructure.persistence.mapper.PrestamoLibroMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PrestamosLibrosRepositoryImpl implements PrestamosLibrosRepository {
    private final PrestamoLibroMapper prestamoLibroMapper;

    public PrestamosLibrosRepositoryImpl(PrestamoLibroMapper prestamoLibroMapper) {
        this.prestamoLibroMapper = prestamoLibroMapper;
    }

    @Override
    public List<Prestamos> findAllByUser(String username) {
        return prestamoLibroMapper.findPrestamosByUsername(username);
    }
}
