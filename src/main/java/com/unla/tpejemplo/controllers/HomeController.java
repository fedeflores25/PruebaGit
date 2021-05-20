package com.unla.tpejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.tpejemplo.hellpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {

	
	@GetMapping("/index")
		public String index() {
			return ViewRouteHelper.INDEX;
		}
	//redirecciono siempre al index
	@GetMapping("/")
	public RedirectView redirecToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}
	
	
	}//fin home

