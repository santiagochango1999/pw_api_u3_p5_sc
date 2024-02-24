package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaRepositoryImp implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myquery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id=:id", Materia.class);
		myquery.setParameter("id", id);
		System.out.println(myquery.getResultList());
		return myquery.getResultList();
	}

}
