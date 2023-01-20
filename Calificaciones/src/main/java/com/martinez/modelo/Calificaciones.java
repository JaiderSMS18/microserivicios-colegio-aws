package com.martinez.modelo;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Calificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int calificacion;
}
