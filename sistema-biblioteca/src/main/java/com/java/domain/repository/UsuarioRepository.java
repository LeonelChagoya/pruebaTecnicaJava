package com.java.domain.repository;

import com.java.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository {
    Usuario findByUsername(String username);
    List<Usuario> findAll(int offset, int limit);
    Optional<Usuario> findById(Long id);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(Long id);
}
