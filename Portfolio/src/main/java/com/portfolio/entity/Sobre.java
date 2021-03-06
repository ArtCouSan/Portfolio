package com.portfolio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_SOBRE")
public class Sobre implements Serializable{

	@NotBlank(message = "A descricao é obrigatória!")
	@Size(max = 500, message = "O título deve conter no máximo 500 caractéres!")
	@Column(name = "DESCRICAO_SOBRE", length = 500)
	private String descricao;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOBRE")
	private Long Id;
	
	public Sobre() {

	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(@NotBlank @Size(max = 500) String descricao) {
		this.descricao = descricao;
	}
	
	

}
