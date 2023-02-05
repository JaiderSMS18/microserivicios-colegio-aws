package com.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.entity.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
