package com.portfolio.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
	
	@NotBlank(message = "A data de inicio é obrigatória!")
	@Size(max = 500, message = "O título deve conter no máximo 500 caractéres!")
	@Column(name = "EXPERIENCIA_DTINICIO", length = 500)
	private String DtInicio;

	@ManyToMany
    @JoinTable(name = "TB_EXPERIENCIA_E_ATIVIDADE",
            joinColumns = {
                @JoinColumn(name = "ID_EXPERIENCIA")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ID_EXPERIENCIA_ATIVIDADE")
            })
    private Set<Experiencia_Atividade> atividade;
	
    @Transient
    private Set<Long> idAtividade;
    
    public Set<Long> getIdAtividades() {
        return idAtividade;
    }

    public void setIdAtividades(Set<Long> idAtividade) {
        this.idAtividade = idAtividade;
    }
    
    public Set<Experiencia_Atividade> getAtividades() {
        return atividade;
    }

    public void setAtividades(Set<Experiencia_Atividade> atividade) {
        this.atividade = atividade;
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

	public String getDtInicio() {
		return DtInicio;
	}

	public void setDtInicio(@NotBlank @Size(max = 500) String dtInicio) {
		DtInicio = dtInicio;
	}
	
	
	
}
