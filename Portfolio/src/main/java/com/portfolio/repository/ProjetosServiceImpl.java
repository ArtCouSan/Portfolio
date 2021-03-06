package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Projetos;
import com.portfolio.service.ProjetosService;

@SuppressWarnings("serial")
@Repository
public class ProjetosServiceImpl implements ProjetosService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ProjetosRepository repository;

	@Override
	public List<Projetos> listar() {

		Iterable<Projetos> projetos = repository.findAll();

		Iterator<Projetos> it = projetos.iterator();

		List<Projetos> lista = new ArrayList<Projetos>();

		while (it.hasNext()) {
			Projetos p = (Projetos) it.next();
			lista.add(p);
		}

		return lista;

	}

	@Override
	public Projetos obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Projetos projeto) {
		entityManager.persist(projeto);
	}

	@Override
	@Transactional
	public void alterar(Projetos projeto) {
		entityManager.merge(projeto);
	}

	@Override
	@Transactional
	public void remover(Long codigoProjetos) {

		Projetos p = entityManager.find(Projetos.class, codigoProjetos);

		entityManager.remove(p);
	}

}
