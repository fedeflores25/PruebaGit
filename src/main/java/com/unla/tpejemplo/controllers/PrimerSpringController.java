package com.unla.tpejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/firstspring")
public class PrimerSpringController {

	@GetMapping("helloword")
	public String helloWord() {
		return "HolaMundo"; //nombre del archivo html
	}


	
}
