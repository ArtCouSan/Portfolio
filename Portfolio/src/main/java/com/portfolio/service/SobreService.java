package com.portfolio.service;

import java.io.Serializable;

import java.util.*;
import com.portfolio.entity.Sobre;

public interface SobreService extends Serializable{

	public List<Sobre> listar();
	
	public Sobre obter(Long id);
	
	public void incluir(Sobre sobre);
	
	public void alterar(Sobre sobre);
	
	public void remover(Long codigoSobre);
	
}
