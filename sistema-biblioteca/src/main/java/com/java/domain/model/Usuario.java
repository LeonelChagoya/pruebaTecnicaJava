package com.java.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@EntityScan
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Date fechaRegistro;
    private Boolean estado;
}
