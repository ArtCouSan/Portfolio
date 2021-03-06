package com.portfolio.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.entity.Curso_Complementar;
import com.portfolio.entity.Experiencia;
import com.portfolio.entity.Experiencia_Atividade;
import com.portfolio.entity.Formacao;
import com.portfolio.entity.Projetos;
import com.portfolio.entity.Sobre;
import com.portfolio.service.Curso_ComplementarService;
import com.portfolio.service.ExperienciaService;
import com.portfolio.service.Experiencia_AtividadeService;
import com.portfolio.service.FormacaoService;
import com.portfolio.service.ProjetosService;
import com.portfolio.service.SobreService;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {

	@Autowired
	private SobreService sobreService;
	
	@Autowired
	private FormacaoService formacaoService;
	
	@Autowired 
	private Curso_ComplementarService cursosService;
	
	@Autowired
	private ProjetosService projetosService;
	
	@Autowired
	private Experiencia_AtividadeService atividadeService;
	
	@Autowired
	private ExperienciaService empresasService;
	
	@GetMapping
	public ModelAndView home() {
		
		Sobre sobre = sobreService.obter(1L);
				
		ArrayList<Formacao> formacao = (ArrayList<Formacao>) formacaoService.listar();
		
		ArrayList<Curso_Complementar> cursos = (ArrayList<Curso_Complementar>) cursosService.listar();
		
		ArrayList<Projetos> projeto = (ArrayList<Projetos>) projetosService.listar();

		ArrayList<Experiencia_Atividade> atividades = (ArrayList<Experiencia_Atividade>) atividadeService.listar();

		ArrayList<Experiencia> empresas = (ArrayList<Experiencia>) empresasService.listar();

		ModelAndView modelAndView = new ModelAndView("admin")
				.addObject("sobre", sobre)
				.addObject("formacoes", formacao)
				.addObject("cursos", cursos)
				.addObject("projetos", projeto)
				.addObject("experiencias", empresas)
				.addObject("atividades", atividades);
		return modelAndView;
	}

	
	
}
