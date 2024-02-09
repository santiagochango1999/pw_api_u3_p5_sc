package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTo;

@Service
public class MateriaServiceImp implements IMateriService {

	@Autowired
	private IMateriaRepository MateriaRepository;

	@Override
	public List<MateriaTo> buscarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		List<Materia> lista = this.MateriaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTo> listaFinal = new ArrayList<>();
		for (Materia mat : lista) {
			listaFinal.add(this.convertir(mat));
		}

		return listaFinal;
	}

	private MateriaTo convertir(Materia materia) {
		MateriaTo mat = new MateriaTo();
		mat.setCreditos(materia.getCreditos());
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		return mat;
	}

}
