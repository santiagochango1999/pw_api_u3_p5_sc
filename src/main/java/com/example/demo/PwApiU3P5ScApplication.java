package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class PwApiU3P5ScApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P5ScApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Estudiante e1=new Estudiante();
		e1.setNombre("santiago");
		e1.setApellido("apellido");
		e1.setGenero("M");
		e1.setFechaNacimiento(null);
		
		this.estudianteService.guardar(e1);*/
	}
}
	