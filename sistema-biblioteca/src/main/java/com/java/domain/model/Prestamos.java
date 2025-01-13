package com.java.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamos {
    private Long id;
    private Long idUsuario;
    private Long idLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Boolean estadoPrestamo;
    private Boolean estado;
    private Usuario usuario;
    private CatalogoLibros libro;
}