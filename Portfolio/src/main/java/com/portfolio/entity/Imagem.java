package com.portfolio.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Imagem {

    @Size(min = 1, max = 50)
	private String Nome;
	
    @Size(min = 1, max = 50)
	private String Legenda;

	public String getNome() {
		return Nome;
	}

	public void setNome(@NotBlank @Size(max = 50) String nome) {
		Nome = nome;
	}

	public String getLegenda() {
		return Legenda;
	}

	public void setLegenda(@NotBlank @Size(max = 50) String legenda) {
		Legenda = legenda;
	}
	
    
    
	
}
