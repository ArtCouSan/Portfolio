package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Curso_Complementar;

public interface Curso_ComplementarService extends Serializable{

	public List<Curso_Complementar> listar();
	
	public Curso_Complementar obter(Long id);
	
	public void incluir(Curso_Complementar curso);
	
	public void alterar(Curso_Complementar curso);
	
	public void remover(Long codigoCurso_Complementar);
	
}