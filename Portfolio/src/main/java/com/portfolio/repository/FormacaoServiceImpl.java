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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void incluir(Formacao formacao) {
		entityManager.persist(formacao);
	}

	@Override
	public void alterar(Formacao formacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Long codigoFormacao) {
		// TODO Auto-generated method stub
		
	}

}
