package com.java.infrastructure.controllers;

import com.java.application.dto.UsuarioDTO;
import com.java.application.service.UsuarioService;
import com.java.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return usuarioService.findAll(page, size).stream()
                .map(user -> new UsuarioDTO(user.getUsername(), user.getNombre(), user.getApellidoPaterno(),
                        user.getApellidoMaterno(), user.getEmail()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> showUser(@PathVariable Long id) {
        Optional<Usuario> usuarioOpt = usuarioService.chowUser(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            UsuarioDTO usuarioDTO = new UsuarioDTO(
                    usuario.getUsername(),
                    usuario.getNombre(),
                    usuario.getApellidoPaterno(),
                    usuario.getApellidoMaterno(),
                    usuario.getEmail()
            );
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.update(id, usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
