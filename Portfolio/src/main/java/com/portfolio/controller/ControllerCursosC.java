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

import com.portfolio.entity.Curso_Complementar;
import com.portfolio.service.Curso_ComplementarService;

@Controller
@RequestMapping("/admin/cursosC")
public class ControllerCursosC {

	@Autowired
	private Curso_ComplementarService service;

	@GetMapping
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("adminCursosC").addObject("cursosC", new Curso_Complementar());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView add_update(@ModelAttribute(value = "cursosC") @Valid Curso_Complementar cursosC,
			BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminCursosC");
		}

		if (cursosC.getId() == null) {

			service.incluir(cursosC);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/cursosC");

		} else {

			service.alterar(cursosC);

			attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
			return new ModelAndView("redirect:/admin/");

		}

	}

	@RequestMapping(value = "/search/{id}")
	public ModelAndView edit(@PathVariable("id") String id) {

		Long idF = new Long(id);

		Curso_Complementar cursos = service.obter(idF);

		cursos.setId(idF);

		service.alterar(cursos);

		ModelAndView modelAndView = new ModelAndView("adminCursosC").addObject("cursosC", cursos);
		return modelAndView;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") String id) {

		Long idF = new Long(id);

		service.remover(idF);

		return new ModelAndView("redirect:/admin/");

	}

}
