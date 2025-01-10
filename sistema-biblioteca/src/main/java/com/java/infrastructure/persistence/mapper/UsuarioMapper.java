package com.java.infrastructure.persistence.mapper;


import com.java.domain.model.Usuario;
import org.apache.ibatis.annotations.*;



import java.util.List;

@Mapper
public interface UsuarioMapper {

    @Select("SELECT * FROM Usuarios WHERE username = #{username}")
    @Results({
            @Result(property = "id", column = "id_usuario")
    })
    Usuario findByUsername(String username);

    @Select("SELECT * FROM Usuarios WHERE estado  = 1 OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<Usuario> findAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT * FROM Usuarios WHERE id_usuario = #{id}")
    Usuario findById(Long id);

    @Insert("INSERT INTO Usuarios (username, password, nombre, apellido_paterno, apellido_materno, email, estado) " +
            "VALUES (#{username}, #{password}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno}, #{email}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID_USUARIO")
    void save(Usuario usuario);

    @Update("UPDATE Usuarios SET nombre=#{nombre}, apellido_paterno=#{apellidoPaterno}, " +
            "apellido_materno=#{apellidoMaterno}, email=#{email}, estado=#{estado} WHERE id_usuario=#{id}")
    void update(Usuario usuario);

    @Delete("UPDATE  Usuarios SET estado = 0 WHERE id_usuario=#{id}")
    void delete(Long id);
}
