package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
	
}