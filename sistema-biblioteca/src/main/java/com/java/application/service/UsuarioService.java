package com.java.application.service;

import com.java.domain.model.Usuario;
import com.java.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> findByUsername(String username) {
        return Optional.ofNullable(usuarioRepository.findByUsername(username));
    }

    public List<Usuario> findAll(int page, int size) {
        int offset = page * size;
        return usuarioRepository.findAll(offset, size);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public Optional<Usuario> chowUser(Long id) {
       return  usuarioRepository.findById(id);
    }
    public void update(Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioRepository.update(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(id);
    }
}
