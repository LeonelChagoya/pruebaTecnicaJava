package com.java.infrastructure.persistence.mapper;

import com.java.domain.model.InventarioLibros;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InventarioLibrosMapper {
    @Select("SELECT il.cantidad_total, il.cantidad_disponible, cl.titulo " +
            "FROM Inventario_Libros il " +
            "JOIN Catalogo_Libros cl ON il.id_libro = cl.id_libro " +
            "WHERE cl.estado = 1 " +
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    @Results({
            @Result(property = "cantidadTotal", column = "cantidad_total"),
            @Result(property = "cantidadDisponible", column = "cantidad_disponible"),
            @Result(property = "libro.titulo", column = "titulo")
    })
    List<InventarioLibros> findAll(@Param("offset") int offset, @Param("limit") int limit);

    @Insert("INSERT INTO Inventario_Libros (id_libro,cantidad_total,cantidad_disponible,estado) " +
            "VALUES (#{idLibro}, #{cantidadTotal}, #{cantidadTotal}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID_INVENTARIO")
    void save(InventarioLibros libro);

    @Select("SELECT il.cantidad_total, il.cantidad_disponible, cl.id_libro " +
            "FROM Inventario_Libros il " +
            "JOIN Catalogo_Libros cl ON il.id_libro = cl.id_libro " +
            "WHERE cl.estado = 1 AND il.id_inventario = #{id}")
    @Results({
            @Result(property = "cantidadTotal", column = "cantidad_total"),
            @Result(property = "cantidadDisponible", column = "cantidad_disponible"),
            @Result(property = "libro.id", column = "id_libro")
    })
    InventarioLibros findById(Long id);


}
