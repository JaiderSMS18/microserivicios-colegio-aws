package com.martinez.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.modelo.Usuario;
import com.martinez.repositorio.IUsuarioDao;
import com.martinez.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	@Transactional
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Integer idUsuario) {
		usuarioRepo.deleteById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario encontrarUsuario(Integer idUsuario) {
		return usuarioRepo.findById(idUsuario).orElse(null);
	}



	@Override
	@Transactional(readOnly = true)
	public Integer buscarIdUsuarioByIdentificacionEstudiante(String idEstudiante) {
		return usuarioRepo.findByUser_dni(idEstudiante);
	}

	@Override
	@Transactional
	public boolean findExistUsuario(Integer id) {
		return usuarioRepo.existsById(id);
	}

	@Override
	@Transactional
	public boolean findExistByUsernameCognito(String username) {
		if(usuarioRepo.findByUser_dni(username) != null) {
			return true;
		}
		return false;
	}

}
