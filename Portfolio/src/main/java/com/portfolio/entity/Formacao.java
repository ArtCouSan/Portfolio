package com.portfolio.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Formacao {

	NotBlank(message = "O nome do curso � obrigat�rio!")
    @Size(max = 200, message = "O nome do curso deve conter no m�ximo 200 caract�res!")
	private String Curso;
	
	NotBlank(message = "O per�odo da forma��o � obrigat�rio!")
    @Size(max = 200, message = "O per�odo deve conter no m�ximo 200 caract�res!")
	private String Periodo;
	
	NotBlank(message = "O tipo da forma��o � obrigat�rio!")
    @Size(max = 1, message = "O tipo da forma��o deve ser escolhida!")
	private char Tipo;

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
	
	
	
}
