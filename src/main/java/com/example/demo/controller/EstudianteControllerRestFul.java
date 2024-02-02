package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//API: por el proyecto java
//API: viene determinado por un proyecto y puede tener muchos servicios y muchas capacidades
//el servicio es anlogo a decir el controller y estos dos se les implementa a travez de una clase controller

@RestController//servicio
@RequestMapping(path="/estudiantes") //se le da el nombre del servicio
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	// Metodos= Capacidades
	//GET
	
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	//MMR
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	
	@GetMapping
	public List<Estudiante> buscartodos(@RequestParam(required = false, defaultValue = "M") String genero){
		return this.estudianteService.buscartodos(genero);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscartodos?genero=Masculina
	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path = "/{id}")
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id){
		this.estudianteService.borrar(id);
	}
}
