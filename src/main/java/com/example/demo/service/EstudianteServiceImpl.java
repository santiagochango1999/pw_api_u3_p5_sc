package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public List<Estudiante> buscartodos(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionartodos(genero);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarParcial(String apellido, String nombre, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizarParcial(apellido, nombre, id);
	}

	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public List<EstudianteTO> buscartodosTo() {
		// TODO Auto-generated method stub
		List<Estudiante> list = this.estudianteRepository.seleccionartodos("M");
		List<EstudianteTO> listafinal = new ArrayList<>();
		for (Estudiante est : list) {
			listafinal.add(this.convertir(est));
		}
		return listafinal;
	}

	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estTo = new EstudianteTO();
		estTo.setApellido(est.getApellido());
		estTo.setFechaNacimiento(est.getFechaNacimiento());
		estTo.setGenero(est.getGenero());
		estTo.setId(est.getId());
		estTo.setNombre(est.getNombre());
		return estTo;
	}

}
