package com.java.infrastructure.controllers;

import com.java.application.dto.InventarioLibrosDTO;
import com.java.application.dto.UsuarioDTO;
import com.java.application.service.InventarioLibrosService;
import com.java.domain.model.InventarioLibros;
import com.java.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventarioLibros")
public class InventarioLibrosController {

    private final InventarioLibrosService inventarioLibrosService;

    public InventarioLibrosController(InventarioLibrosService inventarioLibrosService) {
        this.inventarioLibrosService = inventarioLibrosService;
    }


    @GetMapping
    public List<InventarioLibrosDTO> listaInventario(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return inventarioLibrosService.findAll(page, size).stream()
                .map(inv -> new InventarioLibrosDTO(inv.getLibro().getTitulo(),inv.getCantidadTotal()
                        ,inv.getCantidadDisponible()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> crearInventario(@RequestBody InventarioLibros inventarioLibros) {
        inventarioLibrosService.save(inventarioLibros);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<InventarioLibrosDTO> showInventario(@PathVariable Long id) {
        Optional<InventarioLibros> inventarioOpt = inventarioLibrosService.chowInventario(id);
        if (inventarioOpt.isPresent()) {
            InventarioLibros inventario = inventarioOpt.get();
            InventarioLibrosDTO inventarioLibrosDTO = new InventarioLibrosDTO(
                    inventario.getLibro().getId(),
                    inventario.getCantidadTotal(),
                    inventario.getCantidadDisponible()
            );
            return ResponseEntity.ok(inventarioLibrosDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

