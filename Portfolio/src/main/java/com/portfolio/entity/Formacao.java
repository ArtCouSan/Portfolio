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
@Table(name = "TB_FORMACAO")
public class Formacao implements Serializable {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FORMACAO")
	private Long Id;

	@NotBlank(message = "O nome do curso é obrigatario!")
    @Size(max = 200, message = "O nome do curso deve conter no m�ximo 200 caract�res!")
	@Column(name = "FORMACAO_CURSO", length = 200)
	private String Curso;
	
	@NotBlank(message = "O per�odo da forma��o � obrigat�rio!")
    @Size(max = 200, message = "O per�odo deve conter no m�ximo 200 caract�res!")
	@Column(name = "FORMACAO_PERIODO", length = 200)
	private String Periodo;
	
	@Column(name = "FORMACAO_TIPO", length = 1)
	private char Tipo;

	@Size(min = 1, max = 50)
	@Column(name = "IMAGEM_LEGENDA", length = 50)
	private String Legenda;

	@NotBlank(message = "O per�odo de curso � obrigat�rio!")
	@Column(name = "IMAGEM_FOTO", length = 100)
	private String foto;
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLegenda() {
		return Legenda;
	}

	public void setLegenda(@NotBlank @Size(max = 50) String legenda) {
		Legenda = legenda;
	}
	
	public String getCurso() {
		return Curso;
	}
	public void setCurso(@NotBlank @Size(max = 200) String curso) {
		Curso = curso;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(@NotBlank @Size(max = 200) String periodo) {
		Periodo = periodo;
	}
	public char getTipo() {
		return Tipo;
	}
	public void setTipo(@NotBlank @Size(max = 1) char tipo) {
		Tipo = tipo;
	}

	public Formacao() {
	}
	
	
	
}
