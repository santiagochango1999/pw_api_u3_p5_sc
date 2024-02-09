package com.example.demo.service.to;

import java.io.Serializable;


public class MateriaTo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8365511888260282113L;
	
	private Integer id;
	private String nombre;
	private Integer creditos;
	
	
	//SET Y GET
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
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	

}
