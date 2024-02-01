package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImp implements IProfesorService {

	@Autowired
	private IProfesorRepository ProfesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.ProfesorRepository.insertar(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		this.ProfesorRepository.actualizar(profesor);
	}

	@Override
	public void actualizarParcial(String nombre, String titulo, Integer id) {
		// TODO Auto-generated method stub
		this.ProfesorRepository.actualizarParcial(nombre, titulo, id);
	}

	@Override
	public Profesor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.ProfesorRepository.seleccionar(id);
	}

	@Override
	public List<Profesor> buscartodos(String titulo) {
		// TODO Auto-generated method stub
		return this.ProfesorRepository.seleccionartodo(titulo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.ProfesorRepository.eliminar(id);
	}

}
