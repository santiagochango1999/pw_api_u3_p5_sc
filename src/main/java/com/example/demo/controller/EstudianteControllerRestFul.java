package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.service.IMateriService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTo;

//API: por el proyecto java
//API: viene determinado por un proyecto y puede tener muchos servicios y muchas capacidades
//el servicio es anlogo a decir el controller y estos dos se les implementa a travez de una clase controller

@RestController // servicio
@RequestMapping(path = "/estudiantes") // se le da el nombre del servicio
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriService materiService;

	// Metodos= Capacidades
	// GET

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> buscar(@PathVariable Integer id) {
		System.out.println(this.estudianteService.buscar(id));
		// 240: grupo satisfactoria
		// 240: Recurso Estudiante encontrado Satisfactoriamente{
		// esto se lo especifica en un contrato de la API
		// se lo puede realizar de dos maneras
		// 1.-mediante un documento o pdf donde yo especifico la URL de mi API donde que
		// capacidades tiene y que catalogo de respuestas tiene
		// 2.-mediante una herramienta ( SWAGGER.IO = NOS PERMITE DOCUMENTAR A UNA API )
		Estudiante estu = this.estudianteService.buscar(id);
		return ResponseEntity.status(241).body(estu);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar
	// MMR
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1

	@GetMapping(path = "/tmp", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Estudiante>> buscartodos(
			@RequestParam(required = false, defaultValue = "M") String genero) {
		List<Estudiante> lista = this.estudianteService.buscartodos(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje 242", "lista consultada de manera satisfactoria");

		return new ResponseEntity<>(lista, cabeceras, 242);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscartodos?genero=Masculina

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscartodosHateoas(
			@RequestParam(required = false, defaultValue = "M") String genero) {
		List<EstudianteTO> lista = this.estudianteService.buscartodosTo();

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.actualizarParcial(estudiante.getApellido(), estudiante.getNombre(), id);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
	// ----------------------------------------------------------------

	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTo>> ConsultarMateriaPorId(@PathVariable Integer id) {
		List<MateriaTo> lista = this.materiService.buscarPorIdEstudiante(id);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
}
