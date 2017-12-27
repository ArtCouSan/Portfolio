package com.portfolio.service;

import java.io.Serializable;
import java.util.List;

import com.portfolio.entity.Usuario;

public interface UserService extends Serializable{

public List<Usuario> listar();
	
	public Usuario obter(Long id);
	
	public Usuario obterCPF(String CPF);
	
	public void incluir(Usuario user);
	
	public void alterar(Usuario user);
	
	public void remover(Long codigoUser);
	
	
}
