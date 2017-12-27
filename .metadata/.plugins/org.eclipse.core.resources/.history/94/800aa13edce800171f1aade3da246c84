package com.portfolio.repository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sobre obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Sobre sobre) {
		entityManager.persist(sobre);
	}

	@Override
	public void alterar(Sobre sobre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Long codigoSobre) {
		// TODO Auto-generated method stub

	}

}
