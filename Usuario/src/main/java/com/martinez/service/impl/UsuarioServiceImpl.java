package com.martinez.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.modelo.Calificacion;
import com.martinez.modelo.Usuario;
import com.martinez.repositorio.ICalificacionDao;
import com.martinez.repositorio.IUsuarioDao;
import com.martinez.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private ICalificacionDao calificacionRepo;
	
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
	@Transactional
	public List<Calificacion> calificacionesAll() {
		return calificacionRepo.findAll();
	}

	@Override
	@Transactional
	public void guardarCalificacion(Calificacion calificacion) {
		calificacionRepo.save(calificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Double> buscarCalificaciones(Integer idUsuario) {
		return calificacionRepo.findCalificacionesByUsuario(idUsuario);
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

	@Override
	@Transactional
	public ResponseEntity<List<Double>> buscarAllCalificacionesUsuario(String identificacion) {
		if (!findExistByUsernameCognito(identificacion)) {
			return ResponseEntity.notFound().header("El estudiante con la identificacion: " + identificacion + " no EXISTE").build();
		} else if (calificacionRepo.findCalificacionesByUsuario(usuarioRepo.findByUser_dni(identificacion)).size() == 0 ||
				calificacionRepo.findCalificacionesByUsuario(usuarioRepo.findByUser_dni(identificacion)).isEmpty()) {
			return ResponseEntity.notFound().header("El estudiante no tiene calificaciones ID: " + identificacion + " no EXISTE").build();
		}
		return ResponseEntity.ok(calificacionRepo.findCalificacionesByUsuario(usuarioRepo.findByUser_dni(identificacion)));
	}
}
