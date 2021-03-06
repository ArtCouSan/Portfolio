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
@Table(name = "TB_EXPERIENCIA")
public class Experiencia implements Serializable {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPERIENCIA")
	private Long Id;
	
	@NotBlank(message = "A empresa é obrigatória!")
	@Size(max = 500, message = "O título deve conter no máximo 500 caractéres!")
	@Column(name = "EXPERIENCIA_EMPRESA", length = 500)
	private String Empresa;
	
	@NotBlank(message = "O periodo é obrigatório!")
	@Size(max = 500, message = "O título deve conter no máximo 500 caractéres!")
	@Column(name = "EXPERIENCIA_PERIODO", length = 500)
	private String Periodo;
	
	@NotBlank(message = "O cargo é obrigatórip!")
	@Size(max = 500, message = "O título deve conter no máximo 500 caractéres!")
	@Column(name = "EXPERIENCIA_CARGO", length = 500)
	private String Cargo;

    public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

    
	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(@NotBlank @Size(max = 500) String empresa) {
		Empresa = empresa;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(@NotBlank @Size(max = 500) String periodo) {
		Periodo = periodo;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(@NotBlank @Size(max = 500) String cargo) {
		Cargo = cargo;
	}

	public Experiencia() {
	}
	
}
