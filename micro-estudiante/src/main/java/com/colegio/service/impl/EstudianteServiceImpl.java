package com.colegio.service.impl;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<Optional<Estudiante>> buscarEstudiante(Integer idEstudiante) {
		if(!iEstudianteRepo.existsById(idEstudiante)) {
			return new ResponseEntity("No se encontro ningun estudiante con el id: " + idEstudiante, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(iEstudianteRepo.findById(idEstudiante));
	}

	@Override
	public ResponseEntity<String> deleteEstudiante(Integer idEstudiante) {
		if(!iEstudianteRepo.existsById(idEstudiante)) {
			return ResponseEntity.badRequest().body("el estudiante no existe");
		}
		iEstudianteRepo.deleteById(idEstudiante);
		if(iEstudianteRepo.existsById(idEstudiante)) {
			return ResponseEntity.internalServerError().body("se produjo un error no se pudo eliminar al estudiante");
		}
		return ResponseEntity.ok("El estudiante con el id: " + idEstudiante + " fue eliminado exitosamente!!!");
	}

	
}
