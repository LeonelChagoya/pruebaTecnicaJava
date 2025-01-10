package com.java.infrastructure.persistence.mapper;

import com.java.domain.model.CatalogoLibros;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LibrosMapper {

    @Select("SELECT * FROM Catalogo_Libros WHERE estado  = 1 OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<CatalogoLibros> findAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT * FROM Catalogo_Libros WHERE id_libro = #{id}")
    CatalogoLibros findById(Long id);

    @Insert("INSERT INTO Catalogo_Libros (titulo,autor,genero,isbn,descripcion,fecha_publicacion,estado) " +
            "VALUES (#{titulo}, #{autor}, #{genero}, #{isbn}, #{descripcion}, #{fechaPublicacion}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID_LIBRO")
    void save(CatalogoLibros libro);


    @Update("UPDATE Catalogo_Libros SET titulo=#{titulo}, autor=#{autor}, " +
            "genero=#{genero}, isbn=#{isbn}, descripcion=#{descripcion},fecha_publicacion=#{fechaPublicacion}" +
            " WHERE id_libro=#{id}")
    void update(CatalogoLibros libro);

    @Delete("UPDATE  Catalogo_Libros SET estado = 0 WHERE id_libro=#{id}")
    void delete(Long id);
}
