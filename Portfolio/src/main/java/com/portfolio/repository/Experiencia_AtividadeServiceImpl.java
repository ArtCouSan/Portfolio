package com.portfolio.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Experiencia_Atividade;
import com.portfolio.service.Experiencia_AtividadeService;

@SuppressWarnings("serial")
@Repository
public class Experiencia_AtividadeServiceImpl implements Experiencia_AtividadeService{

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Experiencia_AtividadeRepository repository;
	
	@Override
	public List<Experiencia_Atividade> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Experiencia_Atividade obter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Experiencia_Atividade atividade) {
		entityManager.persist(atividade);
	}

	@Override
	public void alterar(Experiencia_Atividade atividade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long codigoExperiencia_Atividade) {
		// TODO Auto-generated method stub
		
	}

}