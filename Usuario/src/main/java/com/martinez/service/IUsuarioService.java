package com.martinez.service;

import java.util.List;

import com.martinez.modelo.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Integer idUsuario);
    
    public Usuario encontrarUsuario(Integer idUsuario);
    
    public Integer buscarIdUsuarioByIdentificacionEstudiante(String idEstudiante);
    
    public boolean findExistUsuario(Integer id);
    
    public boolean findExistByUsernameCognito(String username);
}
