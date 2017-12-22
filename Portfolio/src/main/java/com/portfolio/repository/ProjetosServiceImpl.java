package com.portfolio.repository;

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
public class ProjetosServiceImpl implements ProjetosService{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ProjetosRepository repository;
	
	@Override
	public List<Projetos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projetos obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Projetos projeto) {
		entityManager.persist(projeto);
	}

	@Override
	public void alterar(Projetos projeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long codigoProjetos) {
		// TODO Auto-generated method stub
		
	}

}