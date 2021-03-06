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
	public ModelAndView add_update(@ModelAttribute(value = "sobre") @Valid Sobre sobre,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminSobre");
		}
		
		if(sobre.getId() == null) {
			
			service.incluir(sobre);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/sobre");

			
		}else {
			
			service.alterar(sobre);
			
			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/");
			
		}

	}

	@RequestMapping(value = "/search/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {

		Long idF = new Long(id);

		Sobre sobre = service.obter(idF);

		sobre.setId(idF);

		service.alterar(sobre);

		ModelAndView modelAndView = new ModelAndView("adminSobre").addObject("sobre", sobre);
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") String id) {

		Long idF = new Long(id);

		service.remover(idF);

		return new ModelAndView("redirect:/admin/");
		
	}

	

}
