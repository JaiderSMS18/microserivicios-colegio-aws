package com.colegio.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.colegio.entity.Estudiante;

public interface IEstudianteService {

	public ResponseEntity<List<Estudiante>> allEstudiantes();
	public ResponseEntity<Estudiante> saveEstudiante (Estudiante estudiante);
	public ResponseEntity<Estudiante> updateEstudiante (Estudiante estudiante, Integer idEstudiante);
	public ResponseEntity<Estudiante> buscarEstudiante(Integer idEstudiante);
	public ResponseEntity<String> deleteEstudiante(Integer idEstudiante);
}
