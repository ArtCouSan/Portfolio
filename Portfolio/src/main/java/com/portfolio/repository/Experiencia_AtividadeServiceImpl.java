package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
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
public class Experiencia_AtividadeServiceImpl implements Experiencia_AtividadeService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Experiencia_AtividadeRepository repository;

	@Override
	public List<Experiencia_Atividade> listar() {
		
		Iterable<Experiencia_Atividade> experiencia = repository.findAll();

		Iterator<Experiencia_Atividade> it = experiencia.iterator();

		List<Experiencia_Atividade> lista = new ArrayList<Experiencia_Atividade>();

		while (it.hasNext()) {
			Experiencia_Atividade e = (Experiencia_Atividade) it.next();
			lista.add(e);
		}

		return lista;
	}

	@Override
	public Experiencia_Atividade obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Experiencia_Atividade atividade) {
		entityManager.persist(atividade);
	}

	@Override
	@Transactional
	public void alterar(Experiencia_Atividade atividade) {
		
		entityManager.merge(atividade);
		
	}

	@Override
	@Transactional
	public void remover(Long codigoExperiencia_Atividade) {
		
		Experiencia_Atividade a = entityManager.find(Experiencia_Atividade.class, codigoExperiencia_Atividade);

		entityManager.remove(a);
		
	}

}
