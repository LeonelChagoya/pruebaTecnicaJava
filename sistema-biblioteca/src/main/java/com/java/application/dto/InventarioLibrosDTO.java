package com.java.application.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventarioLibrosDTO {
    private Long idLibro;
    private String titulo;
    private Integer cantidadTotal;
    private Integer cantidadDisponible;

    public InventarioLibrosDTO(String titulo, Integer cantidadTotal, Integer cantidadDisponible) {
        this.titulo = titulo;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
    }

    public InventarioLibrosDTO(Long idLibro, Integer cantidadTotal, Integer cantidadDisponible) {
        this.idLibro = idLibro;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;

    }
}
