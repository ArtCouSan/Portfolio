package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class ControllerLogin {

	@GetMapping
    public String login() {
        return "login";
    }

    @RequestMapping("/error")
    public ModelAndView loginError() {
        return new ModelAndView("/login").addObject("erro", true);
    }
	
}
