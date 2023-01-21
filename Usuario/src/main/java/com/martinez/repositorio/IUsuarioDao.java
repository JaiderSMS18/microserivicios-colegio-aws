package com.martinez.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martinez.modelo.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

	Usuario findByUserDni(String userDni);
}
