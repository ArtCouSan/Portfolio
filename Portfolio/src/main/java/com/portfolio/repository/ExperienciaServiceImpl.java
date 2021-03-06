package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Experiencia;
import com.portfolio.service.ExperienciaService;

@SuppressWarnings("serial")
@Repository
public class ExperienciaServiceImpl implements ExperienciaService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ExperienciaRepository repository;

	@Override
	public List<Experiencia> listar() {

		Iterable<Experiencia> experiencias = repository.findAll();

		Iterator<Experiencia> it = experiencias.iterator();

		List<Experiencia> lista = new ArrayList<Experiencia>();

		while (it.hasNext()) {
			Experiencia e = (Experiencia) it.next();
			lista.add(e);
		}

		return lista;
	}

	@Override
	public Experiencia obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Experiencia experiencia) {
		entityManager.persist(experiencia);
	}

	@Override
	@Transactional
	public void alterar(Experiencia experiencia) {
		entityManager.merge(experiencia);
	}

	@Override
	@Transactional
	public void remover(Long codigoExperiencia) {
		
		Experiencia r = entityManager.find(Experiencia.class, codigoExperiencia);
		
		entityManager.remove(r);

	}

}
