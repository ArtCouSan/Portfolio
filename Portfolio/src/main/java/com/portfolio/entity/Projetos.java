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
@Table(name = "TB_PROJETOS")
public class Projetos implements Serializable {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROJETOS")
	private Long Id;

	@NotBlank(message = "A linguagem � obrigat�ria!")
	@Size(max = 200, message = "A linguagem deve conter no m�ximo 200 caract�res!")
	@Column(name = "PROJETOS_LINGUAGEM", length = 200)
	private String Linguagem;

	@NotBlank(message = "A linguagem a obrigatória!")
	@Size(max = 200, message = "A linguagem deve conter no máximo 200 caracteres!")
	@Column(name = "PROJETOS_TITULO", length = 200)
	private String Titulo;
	
	@NotBlank(message = "O banco de dados � obrigat�rio!")
	@Size(max = 200, message = "O banco de dados deve conter no m�ximo 200 caract�res!")
	@Column(name = "PROJETOS_BANCO_DADS", length = 200)
	private String Banco_Dados;

	@NotBlank(message = "A IDE � obrigat�ria!")
	@Size(max = 200, message = "A IDE deve conter no m�ximo 200 caract�res!")
	@Column(name = "PROJETOS_IDE", length = 200)
	private String IDE;

	@NotBlank(message = "Apresente uma mensagem!")
	@Size(max = 200, message = "Os framework do projetos deve conter no m�ximo 200 caract�res!")
	@Column(name = "PROJETOS_FRAMEWORK_SERVER", length = 200)
	private String Framework_Server;

	@NotBlank(message = "Apresente uma mensagem!")
	@Size(max = 200, message = "Os framework do projetos deve conter no m�ximo 200 caract�res!")
	@Column(name = "PROJETOS_FRAMEWORK_CLIENT", length = 200)
	private String Framework_Client;

	@Size(min = 1, max = 50, message = "A legenda da foto deve conter no maximo 50 caracteres!")
	@Column(name = "IMAGEM_LEGENDA", length = 50)
	private String Legenda;

	@NotBlank(message = "O per�odo de curso � obrigat�rio!")
	@Column(name = "IMAGEM_FOTO", length = 100)
	private String foto;

	@NotBlank(message = "A url é obrigatória!")
	@Column(name = "PROJETOS_URL", length = 100)
	private String Url;

	
	
	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

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

	public String getLinguagem() {
		return Linguagem;
	}

	public void setLinguagem(@NotBlank @Size(max = 200) String linguagem) {
		Linguagem = linguagem;
	}

	public String getBanco_Dados() {
		return Banco_Dados;
	}

	public void setBanco_Dados(@NotBlank @Size(max = 200) String banco_Dados) {
		Banco_Dados = banco_Dados;
	}

	public String getIDE() {
		return IDE;
	}

	public void setIDE(@NotBlank @Size(max = 200) String iDE) {
		IDE = iDE;
	}

	public String getFramework_Server() {
		return Framework_Server;
	}

	public void setFramework_Server(@NotBlank @Size(max = 200) String framework_Server) {
		Framework_Server = framework_Server;
	}

	public String getFramework_Client() {
		return Framework_Client;
	}

	public void setFramework_Client(@NotBlank @Size(max = 200) String framework_Client) {
		Framework_Client = framework_Client;
	}

	public Projetos() {
	}
	
	

}
