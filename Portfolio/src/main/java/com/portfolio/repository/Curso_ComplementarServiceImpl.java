package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Curso_Complementar;
import com.portfolio.service.Curso_ComplementarService;

@SuppressWarnings("serial")
@Repository
public class Curso_ComplementarServiceImpl implements Curso_ComplementarService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Curso_ComplementarRepository repository;

	@Override
	public List<Curso_Complementar> listar() {
		
		Iterable<Curso_Complementar> cursos = repository.findAll();

		Iterator<Curso_Complementar> it = cursos.iterator();

		List<Curso_Complementar> lista = new ArrayList<Curso_Complementar>();

		while (it.hasNext()) {
			Curso_Complementar c = (Curso_Complementar) it.next();
			lista.add(c);
		}

		return lista;
	}

	@Override
	public Curso_Complementar obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Curso_Complementar curso) {
		entityManager.persist(curso);
	}

	@Override
	@Transactional
	public void alterar(Curso_Complementar curso) {
		entityManager.merge(curso);
	}

	@Override
	@Transactional
	public void remover(Long codigoCurso_Complementar) {
		
		Curso_Complementar c = entityManager.find(Curso_Complementar.class, codigoCurso_Complementar);

		entityManager.remove(c);		
				
	}

}
