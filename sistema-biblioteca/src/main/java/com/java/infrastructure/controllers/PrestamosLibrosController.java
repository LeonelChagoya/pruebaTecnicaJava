package com.java.infrastructure.controllers;

import com.java.application.dto.LibrosDTO;
import com.java.application.dto.PrestamoLibroDTO;
import com.java.application.service.PrestamoLibroService;
import com.java.domain.model.CatalogoLibros;
import com.java.domain.model.Prestamos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/prestamos-libros")
public class PrestamosLibrosController {
    private final PrestamoLibroService prestamoLibroService;
    public PrestamosLibrosController(PrestamoLibroService prestamoLibroService) {
        this.prestamoLibroService = prestamoLibroService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Prestamos>> getPrestamosByUsername(@PathVariable String username) {
        List<Prestamos> prestamos = prestamoLibroService.findAll(username);
        return ResponseEntity.ok(prestamos);
    }


}
