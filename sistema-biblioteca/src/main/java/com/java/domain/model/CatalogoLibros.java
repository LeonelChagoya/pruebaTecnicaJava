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

public class CatalogoLibros {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private String descripcion;
    private Date fechaPublicacion;
    private Boolean estado;

}
