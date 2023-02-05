package com.colegio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colegio.entity.Estudiante;
import com.colegio.repository.IEstudianteRepository;
import com.colegio.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository iEstudianteRepo;

	@Override
	public ResponseEntity<List<Estudiante>> allEstudiantes() {
		if(iEstudianteRepo.findAll().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(iEstudianteRepo.findAll());
	}

	@Override
	public ResponseEntity<Estudiante> saveEstudiante(Estudiante estudiante) {
		return new ResponseEntity<Estudiante>(iEstudianteRepo.save(estudiante), HttpStatus.CREATED);
	 }

	@Override
	public ResponseEntity<Estudiante> updateEstudiante(Estudiante estudiante, Integer idEstudiante) {
		if(iEstudianteRepo.findById(idEstudiante).orElse(null) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		estudiante.setId(idEstudiante);
		return ResponseEntity.ok(iEstudianteRepo.save(estudiante));
	}

	@Override
	public ResponseEntity<Estudiante> buscarEstudiante(Integer idEstudiante) {
		return null;
	}

	@Override
	public ResponseEntity<String> deleteEstudiante(Integer idEstudiante) {
		return null;
	}

	
}
