package com.portfolio.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.entity.Experiencia;
import com.portfolio.service.ExperienciaService;

public class ExperienciaServiceImpl implements ExperienciaService{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ExperienciaRepository repository;
	
	@Override
	public List<Experiencia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Experiencia obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Experiencia experiencia) {
		entityManager.persist(experiencia);		
	}

	@Override
	public void alterar(Experiencia experiencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long codigoExperiencia) {
		// TODO Auto-generated method stub
		
	}

}
