package com.java.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioLibros {
    private Long id;
    private Long idLibro;
    private Integer cantidadTotal;
    private Integer cantidadDisponible;
    private Boolean estado;
    private CatalogoLibros libro;
}