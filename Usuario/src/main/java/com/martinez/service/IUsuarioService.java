package com.martinez.service;

import java.util.List;
import java.util.Optional;

import com.martinez.modelo.Calificacion;
import com.martinez.modelo.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Integer idUsuario);
    
    public Usuario encontrarUsuario(Integer idUsuario);
    
    public List<Calificacion> calificacionesAll();
    
    public void guardarCalificacion(Calificacion calificacion);
    
    public List<Double> buscarCalificaciones(Integer idUsuario);
    
    public Integer buscarIdUsuarioByIdentificacionEstudiante(String idEstudiante);
    
    public boolean findExistUsuario(Integer id);
    
}
