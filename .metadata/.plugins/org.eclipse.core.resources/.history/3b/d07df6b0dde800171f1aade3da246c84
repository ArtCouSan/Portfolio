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
import com.portfolio.entity.Formacao;
import com.portfolio.entity.Imagem;
import com.portfolio.service.FormacaoService;

@Controller
@RequestMapping("/admin/formacao")
public class ControllerFormacao {

	@Autowired
	private FormacaoService service;

	@GetMapping
	public ModelAndView home() {

		File file = new File("src//main//resources//static//imgs//formacao");

		File[] arquivos = file.listFiles();

		List<Imagem> imagensCursos = new ArrayList<>();

		Imagem img = null;

		for (File arquivo : arquivos) {

			img = new Imagem();

			int tamanhoNome = arquivo.getName().length();

			String nomeImg = arquivo.getName().substring(0, tamanhoNome - 4);

			img.setNome(nomeImg);

			imagensCursos.add(img);

		}

		ModelAndView modelAndView = new ModelAndView("adminFormacao").addObject("formacao", new Formacao())
				.addObject("listImagens", imagensCursos);
		return modelAndView;
		
	}

	@PostMapping
	public ModelAndView add(@ModelAttribute(value = "formacao") @Valid Formacao formacao, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return new ModelAndView("adminFormacao");
		}

		service.incluir(formacao);

		attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
		return new ModelAndView("redirect:/adminFormacao");

	}

}
