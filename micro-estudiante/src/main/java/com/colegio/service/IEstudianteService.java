package com.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.colegio.entity.Estudiante;

public interface IEstudianteService {

	public ResponseEntity<List<Estudiante>> allEstudiantes();
	public ResponseEntity<Estudiante> saveEstudiante (Estudiante estudiante);
	public ResponseEntity<Estudiante> updateEstudiante (Estudiante estudiante, Integer idEstudiante);
	public ResponseEntity<Optional<Estudiante>> buscarEstudiante(Integer idEstudiante);
	public ResponseEntity<String> deleteEstudiante(Integer idEstudiante);
}
