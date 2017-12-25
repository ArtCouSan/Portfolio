package com.portfolio.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

import com.portfolio.entity.Curso_Complementar;
import com.portfolio.entity.Imagem;
import com.portfolio.service.Curso_ComplementarService;

@Controller
@RequestMapping("/admin/cursosC")
public class ControllerCursosC {

	@Autowired
	private Curso_ComplementarService service;

	@GetMapping
	public ModelAndView home() {
		
		File file = new File("src//main//resources//static//imgs//cursosC");
		
		File[] arquivos = file.listFiles();

		List <Imagem> imagensCursos = new ArrayList<>();
		
		Imagem img = null;
		
		for (File arquivo : arquivos) {
			
			img = new Imagem();
			
			int tamanhoNome = arquivo.getName().length();
			
			String nomeImg = arquivo.getName().substring(0, tamanhoNome - 4);
			
			img.setNome(nomeImg);
			
			imagensCursos.add(img);
			
		}

		ModelAndView modelAndView = new ModelAndView("adminCursosC").addObject("cursosC", new Curso_Complementar()).addObject("listImagens", imagensCursos);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView add(@ModelAttribute(value = "cursosC") @Valid Curso_Complementar cursosC, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminCursosC");
		}

		service.incluir(cursosC);

		attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
		return new ModelAndView("redirect:/admin/cursosC");

	}
}
