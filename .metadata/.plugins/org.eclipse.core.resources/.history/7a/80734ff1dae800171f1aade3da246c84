package com.portfolio.repository;

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
public class Curso_ComplementarServiceImpl implements Curso_ComplementarService{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Curso_ComplementarRepository repository;
	
	@Override
	public List<Curso_Complementar> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso_Complementar obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Curso_Complementar curso) {
		entityManager.persist(curso);	
	}

	@Override
	public void alterar(Curso_Complementar curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long codigoCurso_Complementar) {
		// TODO Auto-generated method stub
		
	}

}
