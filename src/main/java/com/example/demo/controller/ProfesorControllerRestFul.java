package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {

	@Autowired
	private IProfesorService profesorService;

	@GetMapping(path = "/{id}")
	public Profesor busca(@PathVariable Integer id) {
		return this.profesorService.buscar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/profesores

	@PostMapping
	public void guardar(@RequestBody Profesor profesor) {
		this.profesorService.guardar(profesor);
	}

	// http://localhost:8080/API/v1.0/Matricula/profesores/guardar

	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.actualizar(profesor);
	}

	// http://localhost:8080/API/v1.0/Matricula/profesores/actualizar

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.profesorService.borrar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/profesores/delete
	
	@GetMapping
	public List<Profesor> buscartodos(@RequestParam String titulo){
		return this.profesorService.buscartodos(titulo);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/profesores/buscartodos?titulo=Matematico
	
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.actualizarParcial(profesor.getNombre(), profesor.getTitulo(), id);
	}
	
	// http://localhost:8080/API/v1.0/Matricula/profesores/actualizarParcial

}
