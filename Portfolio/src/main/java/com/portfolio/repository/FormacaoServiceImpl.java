package com.portfolio.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Formacao;
import com.portfolio.service.FormacaoService;

@SuppressWarnings("serial")
@Repository
public class FormacaoServiceImpl implements FormacaoService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private FormacaoRepository repository;
	
	@Override
	public List<Formacao> listar() {
		
		Iterable<Formacao> formacoes = repository.findAll();
		
		Iterator<Formacao> it = formacoes.iterator();
		
		List<Formacao> lista = new ArrayList<Formacao>();
		
		while (it.hasNext()) {
            Formacao f = (Formacao) it.next();
            lista.add(f);
        }
		
		return lista;
		
	}

	@Override
	public Formacao obter(Long id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void incluir(Formacao formacao) {
		entityManager.persist(formacao);
	}

	@Override
	@Transactional
	public void alterar(Formacao formacao) {
		entityManager.merge(formacao);		
	}

	@Override
	@Transactional
	public void remover(Long codigoFormacao) {
		
		Formacao f = entityManager.find(Formacao.class, codigoFormacao);
		
		entityManager.remove(f);
		
	}

}
