package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(path = "/buscar")
	public Estudiante buscar() {
		return this.estudianteService.buscar(1);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	
	
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	//http://localhost:8080//API/v1.0/Matricula/estudiantes/guardar
}
