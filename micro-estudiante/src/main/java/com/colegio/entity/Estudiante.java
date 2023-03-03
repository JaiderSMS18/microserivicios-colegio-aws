package com.colegio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombres;
	private String apellidos;
	private String genero;
	private String direccion;
	private String correo_electronico;
	private String curso;
	private Double promedio;
	private Integer id_usuario;
	
	public Estudiante() {}

	
	public Estudiante( String nombres, String apellidos, String genero, String direccion,
			String correoElectronico, String curso, Double nota, Integer id_usuario, Integer codigo_materia) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.genero = genero;
		this.direccion = direccion;
		this.correo_electronico = correoElectronico;
		this.curso = curso;
		this.promedio = nota;
		this.id_usuario = id_usuario;
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
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correoElectronico) {
		this.correo_electronico = correoElectronico;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double nota) {
		this.promedio = nota;
	}


	public Integer getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}


	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", direccion=" + direccion + ", correoElectronico=" + correo_electronico + ", curso=" + curso
				+ ", promedio=" + promedio + ", idUsuario=" + id_usuario + "]";
	}
	
}
