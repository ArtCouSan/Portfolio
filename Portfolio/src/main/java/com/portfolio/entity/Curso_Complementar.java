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
@Table(name = "TB_CURSO_COMPLEMENTAR")
public class Curso_Complementar implements Serializable{

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CURSO_COMPLEMENTAR")
	private Long Id;
	
	@NotBlank(message = "O nome do curso é obrigatório!")
    @Size(max = 200, message = "O t�tulo deve conter no m�ximo 200 caract�res!")
	@Column(name = "CURSO_COMPLEMENTAR_CURSO", length = 200)
	private String Curso;
	
	@NotBlank(message = "O nome da instituicao � obrigat�rio!")
    @Size(max = 200, message = "O t�tulo deve conter no m�ximo 200 caract�res!")
	@Column(name = "CURSO_COMPLEMENTAR_INSITUICAO", length = 200)
	private String Instituicao;
	
	@NotBlank(message = "O per�odo de curso � obrigat�rio!")
    @Size(max = 50, message = "O t�tulo deve conter no m�ximo 50 caract�res!")
	@Column(name = "CURSO_COMPLEMENTAR_PERIODO", length = 50)
	private String Periodo;

	
	@Size(min = 1, max = 50)
	@Column(name = "IMAGEM_LEGENDA", length = 100)
	private String Legenda;

	@NotBlank(message = "O per�odo de curso � obrigat�rio!")
	@Column(name = "IMAGEM_FOTO", length = 100)
	private String foto;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
	public String getInstituicao() {
		return Instituicao;
	}
	public void setInstituicao(@NotBlank @Size(max = 200) String instituicao) {
		Instituicao = instituicao;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo (@NotBlank @Size(max = 50) String periodo) {
		Periodo = periodo;
	}

	public Curso_Complementar() {
	}
	
}
