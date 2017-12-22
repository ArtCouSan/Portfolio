package com.portfolio.controller;

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

import com.portfolio.entity.Sobre;
import com.portfolio.service.SobreService;

@Controller
@RequestMapping("/admin/sobre")
public class ControllerSobre {

	@Autowired
	private SobreService service;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("adminSobre").addObject("sobre", new Sobre());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView add(
			@ModelAttribute(value = "sobre") 
			@Valid Sobre sobre, 
			BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminSobre");
		}

		service.incluir(sobre);
		
		attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
		return new ModelAndView("redirect:/adminSobre");

	}

}