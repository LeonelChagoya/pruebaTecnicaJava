package com.java.infrastructure.persistence.mapper;

import com.java.domain.model.Rol;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RolMapper {

    @Select("SELECT r.id_rol, r.nombre_rol " +
            "FROM Roles r " +
            "JOIN Usuarios_Roles ur ON r.id_rol = ur.id_rol " +
            "WHERE ur.id_usuario = #{id} "
            )
    List<Rol> rolesUsuario(@Param("id") Long id);

}

