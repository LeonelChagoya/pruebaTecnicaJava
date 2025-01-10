package com.java.infrastructure.persistence.repository;

import com.java.domain.model.Usuario;
import com.java.domain.repository.UsuarioRepository;
import com.java.infrastructure.persistence.mapper.UsuarioMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryImpl(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }


    @Override
    public Usuario findByUsername(String username) {
        return usuarioMapper.findByUsername(username);
    }

    @Override
    public List<Usuario> findAll(int offset, int limit) {
        return usuarioMapper.findAll(offset, limit);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usuarioMapper.findById(id));
    }

    @Override
    public void save(Usuario usuario) {
        usuarioMapper.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioMapper.update(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioMapper.delete(id);
    }
}
