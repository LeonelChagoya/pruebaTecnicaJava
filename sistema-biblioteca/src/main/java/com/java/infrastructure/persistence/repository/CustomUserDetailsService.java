//package com.java.infrastructure.persistence.repository;
//
//import com.java.domain.model.Usuario;
//import com.java.infrastructure.persistence.mapper.UsuarioMapper;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UsuarioMapper usuarioMapper;
//
//    public CustomUserDetailsService(UsuarioMapper usuarioMapper) {
//        this.usuarioMapper = usuarioMapper;
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioMapper.findByUsername(username);
//        if (usuario == null) {
//            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
//        }
//
//        return User.builder()
//                .username(usuario.getUsername())
//                .password(usuario.getPassword())
//                .authorities("ROLE_ADMIN")
//                .build();
//     }
//    }
