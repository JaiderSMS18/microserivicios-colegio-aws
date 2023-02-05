package com.colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.entity.Estudiante;
import com.colegio.service.IEstudianteService;

@RestController
@RequestMapping(value = "/estudiante")
public class EstudianteController {

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
	
	@PutMapping(value = "/{idEstudiante}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable("idEstudiante") Integer idEstudiante) {
		return estudianteService.updateEstudiante(estudiante, idEstudiante);
	}
}
