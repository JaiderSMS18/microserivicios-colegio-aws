package com.martinez.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.martinez.modelo.Calificacion;

public interface ICalificacionDao extends JpaRepository<Calificacion, Long> {

	@Query(value = "select c.nota from calificacion c where c.usuario=:idUsuario", nativeQuery = true)
	public List<Double> findCalificacionesByUsuario(@Param("idUsuario") Integer idUsuario);
	
}
