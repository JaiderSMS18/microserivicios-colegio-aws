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

import com.martinez.configurations.JwtProvider;
import com.martinez.modelo.Calificacion;
import com.martinez.service.IUsuarioService;
import com.nimbusds.jwt.JWTClaimsSet;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping(value = "/listarNotas/{idEstudiante}")
	public ResponseEntity<List<Double>> buscarCalificacionesByusuario(
			@PathVariable("idEstudiante") String identificacionEstudiante,
			HttpServletResponse response) {
		response.addHeader("AutorizarToken", "devuelto");
		return usuarioService.buscarAllCalificacionesUsuario(identificacionEstudiante);
	}

	@PostMapping(value = "/guardarCalificacion/{identificacion}")
	public ResponseEntity<String> guardarCalificacionByIdUsuario(@PathVariable("identificacion") Integer identificaci,
			@RequestBody Calificacion notas) {
		String idUsuario = String.valueOf(identificaci);
		if (usuarioService
				.encontrarUsuario(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario)) != null) {
			return new ResponseEntity<>("El estudiante con la identificacion: " + idUsuario + " no EXISTE",
					HttpStatus.FOUND);
		}
		notas.setUsuario(
				usuarioService.encontrarUsuario(usuarioService.buscarIdUsuarioByIdentificacionEstudiante(idUsuario)));
		usuarioService.guardarCalificacion(notas);
		return new ResponseEntity<>("se guardo la calificacion del estudiante con la identificacion: " + idUsuario,
				HttpStatus.CREATED);
	}

}
