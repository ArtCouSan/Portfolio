package com.portfolio.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;

@Controller
@RequestMapping("/admin/upload")
public class ControllerUploadImg {

	@GetMapping
	public ModelAndView home() {

		return new ModelAndView("/adminUpload");

	}

	@PostMapping()
	public ModelAndView singleFileUpload(@RequestParam("local") String id, @RequestParam("file") MultipartFile file,
			RedirectAttributes attributes) {

		if (file.isEmpty()) {

			attributes.addFlashAttribute("mensagem", "Selecione uma imagem");

			return new ModelAndView("adminUpload");

		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();

			Path path = Paths.get("src//main//resources//static//imgs//" + id + "//" + file.getOriginalFilename());

			Files.write(path, bytes);

			attributes.addFlashAttribute("mensagem", "Sucesso");

		} catch (IOException e) {

			e.printStackTrace();

		}

		attributes.addFlashAttribute("mensagem", "Enviado com sucesso");
		return new ModelAndView("redirect:/admin/");

	}

}