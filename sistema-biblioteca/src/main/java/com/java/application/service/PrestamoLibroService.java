package com.java.application.service;


import com.java.domain.model.Prestamos;

import com.java.domain.repository.PrestamosLibrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrestamoLibroService {
    final private PrestamosLibrosRepository prestamosLibrosRepository;

    public PrestamoLibroService(PrestamosLibrosRepository prestamosLibrosRepository) {
        this.prestamosLibrosRepository = prestamosLibrosRepository;

    }

    public List<Prestamos> findAll(String username) {
        return prestamosLibrosRepository.findAllByUser(username);
    }
}
