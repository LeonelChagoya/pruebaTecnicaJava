package com.java.infrastructure.controllers;

import com.java.application.dto.LibrosDTO;
import com.java.application.service.LibrosService;
import com.java.domain.model.CatalogoLibros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")

public class LibrosController {
    private LibrosService librosService;
    public LibrosController(LibrosService librosService) {
        this.librosService = librosService;
    }

    @GetMapping
    public List<LibrosDTO> listarLibros(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                        HttpServletRequest request) {
        return librosService.findAll(page, size).stream()
                .map(libro -> new LibrosDTO(
                        libro.getId(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getGenero(),
                        libro.getIsbn(),
                        libro.getFechaPublicacion(),
                        libro.getDescripcion()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> crearLibro(@RequestBody CatalogoLibros libro) {
        librosService.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibrosDTO> showLibro(@PathVariable Long id) {
        Optional<CatalogoLibros> libro = librosService.chowLibro(id);
        if (libro.isPresent()) {
            CatalogoLibros  libroShow = libro.get();
            LibrosDTO libroDto = new LibrosDTO(
                    libroShow.getId(),
                    libroShow.getTitulo(),
                    libroShow.getAutor(),
                    libroShow.getGenero(),
                    libroShow.getIsbn(),
                    libroShow.getFechaPublicacion(),
                    libroShow.getDescripcion()
            );
            return ResponseEntity.ok(libroDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarLibro(@PathVariable Long id, @RequestBody CatalogoLibros libros) {
        librosService.update(id, libros);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        librosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
