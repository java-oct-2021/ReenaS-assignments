package com.reena.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("firstName","Kevin");
		model.addAttribute("stack","Java");
		return "index.jsp";
	}
	@RequestMapping("/java")
	public String helloJava() {
		return "I love coding in Java";
	}
	@RequestMapping("/welcome")
	public String welcome(@RequestParam(value="q") String firstName) {
		return "Welcome to Java " + firstName;
	}

}
