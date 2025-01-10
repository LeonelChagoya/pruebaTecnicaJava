package com.java.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String username;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private Boolean estado;
}

