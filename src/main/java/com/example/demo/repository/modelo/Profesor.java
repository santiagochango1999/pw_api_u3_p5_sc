package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {

	@Id
	@GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize = 1)
	@Column(name = "pro_id")
	private Integer id;
	@Column(name = "pro_nombre")
	private String nombre;
	@Column(name = "pro_apellido")
	private String apellido;
	@Column(name = "pro_cedula")
	private String cedula;
	@Column(name = "pro_genero")
	private String genero;
	@Column(name = "pro_edad")
	private Integer edad;
	@Column(name = "pro_fechaNacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "pro_titulo")
	private String titulo;

	// GET Y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
