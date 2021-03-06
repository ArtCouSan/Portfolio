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

import com.portfolio.entity.Projetos;
import com.portfolio.service.ProjetosService;

@Controller
@RequestMapping("/admin/projeto")
public class ControllerProjetos {

	@Autowired
	private ProjetosService service;

	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("adminProjetos").addObject("projeto", new Projetos());
		return modelAndView;

	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "projeto") @Valid Projetos projetos, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminProjetos");
		}

		if (projetos.getId() == null) {

			service.incluir(projetos);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/projeto");

		} else {

			service.alterar(projetos);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/");

		}

	}

	@RequestMapping(value = "/search/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {
		
		Long idF = new Long(id);
		
		Projetos projetos = service.obter(idF);
		
		service.alterar(projetos);
		
		ModelAndView modelAndView = new ModelAndView("adminProjetos").addObject("projeto", projetos);
		return modelAndView;
		
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") String id) {

		Long idF = new Long(id);

		service.remover(idF);

		return new ModelAndView("redirect:/admin/");

	}

}
