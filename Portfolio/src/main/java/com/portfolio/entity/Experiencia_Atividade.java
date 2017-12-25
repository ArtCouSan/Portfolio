package com.portfolio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_EXPERIENCIA_ATIVIDADE")
public class Experiencia_Atividade implements Serializable {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPERIENCIA_ATIVIDADE")
	private Long Id;

	@NotBlank(message = "A atividade é obrigatória!")
	@Size(max = 500, message = "A atividade deve conter no máximo 500 caractéres!")
	@Column(name = "EXPERIENCIA_ATIVIDADE_ATIVDADE", length = 500)
	private String Atividade;

	public Long getId() {
		return Id;
	}

	@Transient
	private Long idExperiencia;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EXPERIENCIA", nullable = false)
    private Experiencia experiencia;
	
	public Long getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Long idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAtividade() {
		return Atividade;
	}

	public void setAtividade(@NotBlank @Size(max = 500) String atividade) {
		Atividade = atividade;
	}

	public Experiencia_Atividade() {
	}

}
