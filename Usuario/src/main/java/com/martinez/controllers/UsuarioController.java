package com.martinez.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.martinez.modelo.Calificacion;
import com.martinez.service.IUsuarioService;

@RestController
public class UsuarioController {//implements WebMvcConfigurer {

	@Autowired
	private IUsuarioService usuarioService;
	
	/*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }*/
	
	@GetMapping(value = "/listarNotas/{idEstudiante}")
	public ResponseEntity<List<Double>> buscarCalificacionesDelusuario(@PathVariable("idEstudiante") String identificacionEstudiante){
		if(usuarioService.buscarCalificaciones(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(identificacionEstudiante)).isEmpty()) {
			return new ResponseEntity("No se encontro ningun resultado de las claificaciones "
					+ "del estudiante con la identificacion: " + 
					identificacionEstudiante, HttpStatus.FOUND);
		}
		return ResponseEntity.ok(usuarioService.buscarCalificaciones(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(identificacionEstudiante)));
	}
	
	
	@PostMapping(value = "/guardarCalificacion/{identificacion}")
	public ResponseEntity<String> guardarCalificacionByIdUsuario(@PathVariable("identificacion") Integer identificaci, @RequestBody Calificacion notas){
		String idUsuario = String.valueOf(identificaci);
		
		if(usuarioService.findExistUsuario(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario))) {
			return new ResponseEntity<>("El estudiante con la identificacion: " + idUsuario + " no EXISTE", HttpStatus.FOUND);
		} 
		notas.setUsuario(usuarioService.encontrarUsuario(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario)));
		usuarioService.guardarCalificacion(notas);
		return new ResponseEntity<>("se guardo la calificacion del estudiante con la identificacion: "  + idUsuario, HttpStatus.CREATED);
	}
	
}
