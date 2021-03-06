package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Formacao;

public interface FormacaoService extends Serializable{

	public List<Formacao> listar();
	
	public Formacao obter(Long id);
	
	public void incluir(Formacao formacao);
	
	public void alterar(Formacao formacao);
	
	public void remover(Long codigoFormacao);
	
}