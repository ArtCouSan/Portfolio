package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Experiencia;

public interface ExperienciaService extends Serializable{

	public List<Experiencia> listar();
	
	public Experiencia obter(Long id);
	
	public void incluir(Experiencia experiencia);
	
	public void alterar(Experiencia experiencia);
	
	public void remover(Long codigoExperiencia);
	
}