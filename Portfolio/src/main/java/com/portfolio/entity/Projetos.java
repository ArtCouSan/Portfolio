package com.portfolio.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Projetos {

	NotBlank(message = "A linguagem é obrigatória!")
    @Size(max = 200, message = "A linguagem deve conter no máximo 200 caractéres!")
	private String Linguagem;
	
	NotBlank(message = "O banco de dados é obrigatório!")
    @Size(max = 200, message = "O banco de dados deve conter no máximo 200 caractéres!")
	private String Banco_Dados;
	
	NotBlank(message = "A IDE é obrigatória!")
    @Size(max = 200, message = "A IDE deve conter no máximo 200 caractéres!")
	private String IDE;
	
	NotBlank(message = "Apresente uma mensagem!")
    @Size(max = 200, message = "Os framework do projetos deve conter no máximo 200 caractéres!")
	private String Framework_Server;
	
	NotBlank(message = "Apresente uma mensagem!")
    @Size(max = 200, message = "Os framework do projetos deve conter no máximo 200 caractéres!")
	private String Framework_Client;

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
	
	
	
	
}
