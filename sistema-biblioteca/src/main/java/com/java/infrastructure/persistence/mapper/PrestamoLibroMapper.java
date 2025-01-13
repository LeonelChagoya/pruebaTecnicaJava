package com.java.infrastructure.persistence.mapper;


import com.java.domain.model.Prestamos;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PrestamoLibroMapper {
    @Insert("INSERT INTO Prestamos (id_usuario,id_libro) " +
            "VALUES (#{idIsuario}, #{idLibro})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID_PRESTAMO")
    void save(Prestamos prestamo);

    @Select("SELECT p.id_prestamo, p.id_usuario, p.id_libro, p.fecha_prestamo, p.fecha_devolucion, p.estado_prestamo " +
            "FROM Prestamos p " +
            "JOIN Usuarios u ON p.id_usuario = u.id_usuario " +
            "WHERE u.username = #{username}")
    @Results({
            @Result(property = "id", column = "id_prestamo"),
            @Result(property = "idUsuario", column = "id_usuario"),
            @Result(property = "idLibro", column = "id_libro"),
            @Result(property = "fechaPrestamo", column = "fecha_prestamo"),
            @Result(property = "fechaDevolucion", column = "fecha_devolucion"),
            @Result(property = "estadoPrestamo", column = "estado_prestamo"),
            @Result(property = "usuario.id", column = "id_usuario"),
            @Result(property = "libro.id", column = "id_libro")
    })
    List<Prestamos> findPrestamosByUsername(String username);
}
