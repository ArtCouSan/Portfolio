package com.portfolio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.entity.Experiencia;
import com.portfolio.service.ExperienciaService;

@RequestMapping("/admin/experiencia")
@Controller
public class ControllerExperiencia {

	@Autowired
	private ExperienciaService serviceExperiencia;


	@GetMapping
	public ModelAndView home() {

		return new ModelAndView("/adminExperiencia").addObject("experiencia", new Experiencia());

	}

	@PostMapping
	public ModelAndView add(@ModelAttribute(value = "experiencia") @Valid Experiencia experiencia, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminExperiencia");
		}
		
		serviceExperiencia.incluir(experiencia);

		return home();

	}
	
	@RequestMapping(value = "/alterar/{id}")
	public ModelAndView update(@PathVariable("id") String id, @ModelAttribute(value = "experiencia") @Valid Experiencia experiencia, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("admin");
		}
		
		Long idF = new Long(id);

		experiencia.setId(idF);
		
		serviceExperiencia.alterar(experiencia);

		return new ModelAndView("/admin");

	}
	

}
