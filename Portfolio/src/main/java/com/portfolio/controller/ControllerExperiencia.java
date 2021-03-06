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
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView add_update(@ModelAttribute(value = "experiencia") @Valid Experiencia experiencia, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminExperiencia");
		}
		
		if(experiencia.getId() == null) {
			
			serviceExperiencia.incluir(experiencia);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/experiencia");		
			
		}else {
			
			serviceExperiencia.alterar(experiencia);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/");
			
		}
		
	
	}
	
	@RequestMapping(value = "/search/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {

		Long idF = new Long(id);
		
		Experiencia experiencia = serviceExperiencia.obter(idF);
		
		experiencia.setId(idF);
		
		serviceExperiencia.alterar(experiencia);
		
		ModelAndView modelAndView = new ModelAndView("adminExperiencia").addObject("experiencia", experiencia);
		return modelAndView;
		
	}	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") String id) {

		Long idF = new Long(id);

		serviceExperiencia.remover(idF);

		return new ModelAndView("redirect:/admin/");
		
	}
	

}
