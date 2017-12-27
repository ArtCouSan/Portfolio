package com.portfolio.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.entity.Experiencia;
import com.portfolio.entity.Experiencia_Atividade;
import com.portfolio.service.ExperienciaService;
import com.portfolio.service.Experiencia_AtividadeService;

@RequestMapping("/admin/atividade")
@Controller
public class ControllerAtividade {

	@Autowired
	private ExperienciaService serviceEmpresas;

	@Autowired
	private Experiencia_AtividadeService serviceAtividade;


	@GetMapping
	public ModelAndView home() {

		ArrayList<Experiencia> empresas = (ArrayList<Experiencia>) serviceEmpresas.listar();
		
		return new ModelAndView("/adminAtividade")
				.addObject("experiencia", new Experiencia_Atividade())
				.addObject("empresas", empresas);

	}

	@PostMapping
	public ModelAndView add(@ModelAttribute(value = "experiencia") @Valid Experiencia_Atividade experiencia, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminExperiencia");
		}
		
		serviceAtividade.incluir(experiencia);

		return home();

	}
	
}