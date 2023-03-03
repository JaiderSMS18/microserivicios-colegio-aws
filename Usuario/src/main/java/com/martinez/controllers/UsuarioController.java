package com.martinez.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.martinez.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	
}
