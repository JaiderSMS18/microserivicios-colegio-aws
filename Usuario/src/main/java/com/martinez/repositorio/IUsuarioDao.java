package com.martinez.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.martinez.modelo.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

	//Usuario findByUserDni(String userDni);
	
	@Query(value = "select usuario.id_usuario from usuario where usuario.user_dni=:identificacionEstudiante", nativeQuery = true)
	Integer findByUser_dni(@Param("identificacionEstudiante") String identificacionEstudiante);
}
