package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Experiencia_Atividade;

public interface Experiencia_AtividadeService extends Serializable{

	public List<Experiencia_Atividade> listar();
	
	public Experiencia_Atividade obter(Long id);
	
	public void incluir(Experiencia_Atividade experiencia);
	
	public void alterar(Experiencia_Atividade experiencia);
	
	public void remover(Long codigoExperiencia_Atividade);
	
}
