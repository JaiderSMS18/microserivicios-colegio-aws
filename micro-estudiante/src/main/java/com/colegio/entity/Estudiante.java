package com.colegio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String genero;
	private String direccion;
	private String correoElectronico;
	private String curso;
	
	public Estudiante() {}

	
	public Estudiante( String nombres, String apellidos, String genero, String direccion,
			String correoElectronico, String curso) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + ", curso=" + curso + "]";
	}
	
}
