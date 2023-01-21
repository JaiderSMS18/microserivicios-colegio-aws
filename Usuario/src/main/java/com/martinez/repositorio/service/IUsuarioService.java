package com.martinez.repositorio.service;

import java.util.List;
import java.util.Optional;

import com.martinez.modelo.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Optional<Usuario> encontrarUsuario(Usuario usuario);
}
