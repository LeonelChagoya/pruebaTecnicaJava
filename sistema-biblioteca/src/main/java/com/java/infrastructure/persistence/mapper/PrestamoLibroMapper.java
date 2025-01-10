package com.java.infrastructure.persistence.mapper;


import com.java.domain.model.Prestamos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PrestamoLibroMapper {
    @Insert("INSERT INTO Prestamos (id_usuario,id_libro) " +
            "VALUES (#{idIsuario}, #{idLibro})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID_PRESTAMO")
    void save(Prestamos prestamo);
}
