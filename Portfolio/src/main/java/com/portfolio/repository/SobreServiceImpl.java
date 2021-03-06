package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Sobre;
import com.portfolio.service.SobreService;

@SuppressWarnings("serial")
@Repository
public class SobreServiceImpl implements SobreService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SobreRepository repository;

	@Override
	public List<Sobre> listar() {
		
		Iterable<Sobre> sobre = repository.findAll();

		Iterator<Sobre> it = sobre.iterator();

		List<Sobre> lista = new ArrayList<Sobre>();

		while (it.hasNext()) {
			Sobre c = (Sobre) it.next();
			lista.add(c);
		}

		return lista;
		
	}

	@Override
	public Sobre obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Sobre sobre) {
		entityManager.persist(sobre);
	}

	@Override
	@Transactional
	public void alterar(Sobre sobre) {
		entityManager.merge(sobre);
	}

	@Override
	@Transactional
	public void remover(Long codigoSobre) {

		Sobre s = entityManager.find(Sobre.class, codigoSobre);

		entityManager.remove(s);

	}

}
