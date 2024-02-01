package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorRepository {
	
	public void insertar(Profesor profesor);

	public void actualizar(Profesor profesor);

	public void actualizarParcial(String nombre, String titulo, Integer id);

	public Profesor seleccionar(Integer id);

	public List<Profesor> seleccionartodo(String titulo);

	public void eliminar(Integer id);

}
