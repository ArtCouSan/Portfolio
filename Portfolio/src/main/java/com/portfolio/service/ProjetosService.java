package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Projetos;

public interface ProjetosService extends Serializable{

	public List<Projetos> listar();
	
	public Projetos obter(Long id);
	
	public void incluir(Projetos projeto);
	
	public void alterar(Projetos projeto);
	
	public void remover(Long codigoProjetos);
	
}