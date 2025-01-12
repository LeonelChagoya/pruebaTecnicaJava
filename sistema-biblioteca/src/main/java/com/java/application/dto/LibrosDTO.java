package com.java.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibrosDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private Date fechaPublicacion;
    private String descripcion;
}
