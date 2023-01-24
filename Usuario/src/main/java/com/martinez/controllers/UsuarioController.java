package com.martinez.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.martinez.modelo.Calificacion;
import com.martinez.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	/*@GetMapping(value = "/listarNotas/{idEstudiante}")
	public ResponseEntity<String> buscarCalificacionesDelusuario(@RequestParam("idEstudiante") String identificacionEstudiante){
		if(usuarioService.buscarCalificaciones(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(identificacionEstudiante)).isEmpty()) {
			return new ResponseEntity<>("No se encontro ningun resultado de las claificaciones "
					+ "del estudiante con la identificacion: " + 
					usuarioService.buscarIdUsuarioByIdentificacionEstudiante(identificacionEstudiante), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(usuarioService.buscarCalificaciones(
				usuarioService.buscarIdUsuarioByIdentificacionEstudiante(identificacionEstudiante)).toString(), HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/buscarId/{identificacion}")
	public ResponseEntity<Integer> mostarIdUsuario(@PathVariable("identificacion") Integer identificaci){
		String idUsuario = String.valueOf(identificaci);
		
		if(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario).toString().isEmpty()) {
			return new ResponseEntity<>( identificaci, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario), HttpStatus.OK);
	}
	
	@PostMapping(value = "/guardarCalificacion/{identificacion}")
	public ResponseEntity<String> guardarCalificacionByIdUsuario(@PathVariable("identificacion") Integer identificaci, @RequestBody Calificacion notas){
		String idUsuario = String.valueOf(identificaci);
		
		if() {
			return new ResponseEntity<>("El estudiante con la identificacion: " + idUsuario + " no EXISTE", HttpStatus.FOUND);
		}
		notas.setUsuario(usuarioService.encontrarUsuario(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario)));
		usuarioService.guardarCalificacion(notas);
		return new ResponseEntity<>("se guardo la calificacion del estudiante con la identificacion: "  + idUsuario, HttpStatus.CREATED);
	}
	
}
