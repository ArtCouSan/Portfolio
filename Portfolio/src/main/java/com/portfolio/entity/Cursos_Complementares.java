package com.portfolio.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cursos_Complementares {

	NotBlank(message = "O nome do curso � obrigat�rio!")
    @Size(max = 200, message = "O t�tulo deve conter no m�ximo 200 caract�res!")
	private String Curso;
	
	NotBlank(message = "O nome da instituicao � obrigat�rio!")
    @Size(max = 200, message = "O t�tulo deve conter no m�ximo 200 caract�res!")
	private String Instituicao;
	
	NotBlank(message = "O per�odo de curso � obrigat�rio!")
    @Size(max = 50, message = "O t�tulo deve conter no m�ximo 50 caract�res!")
	private String Periodo;

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
	
	
	
	
}
