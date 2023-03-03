package com.colegio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.entity.Estudiante;
import com.colegio.service.IEstudianteService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping(value = "/estudiante")
public class EstudianteController {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(value = "/all-estudiantes")
	public ResponseEntity<List<Estudiante>> listarEstudiantes() {
		return estudianteService.allEstudiantes();
	}
	
	@PostMapping(value = "/save-estudiante")
	public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteService.saveEstudiante(estudiante);
	}
	
	@PutMapping(value = "/update/{idEstudiante}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable("idEstudiante") Integer idEstudiante) {
		return estudianteService.updateEstudiante(estudiante, idEstudiante);
	}
	
	@DeleteMapping(value = "/eliminar/{idEstudiante}")
	public ResponseEntity<String> eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante) {
		return estudianteService.deleteEstudiante(idEstudiante);
	}
	
	
	@GetMapping(value = "/buscar/{idEstudiante}")
	public ResponseEntity<Optional<Estudiante>> buscarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante) {
		return estudianteService.buscarEstudiante(idEstudiante);
	}
}
