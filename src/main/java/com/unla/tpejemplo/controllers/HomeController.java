package com.unla.tpejemplo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.tpejemplo.hellpers.ViewRouteHelper;
import com.unla.tpejemplo.models.DegreeModel;

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
	
	//Una petición con parámetros
	//se genera un objeto ‘ModelAndView’.
	//Este recibe en la ruta y el nombre de la vista como parámetro de su constructor y luego
	//permite agregar objetos de información para usar posteriormente en la vista
	@GetMapping("/hello")
	public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}
	
	//Una petición con construcción de la ruta, 
	//Se usa normalmente para acceder a la información de un objeto de la base de datos.
	
	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}
	
	
	@GetMapping("/degree")
	public String degree(Model model) {
		model.addAttribute("degree", new DegreeModel());
		return ViewRouteHelper.DEGREE;
	}
	
	//Se agrega la anotacion @Valid para notificar que el objeto que llega tiene validaciones en el modelo y que se tiene que chequear que se cumplan
	//Para cumplir las validaciones se usa el objeto BindingResult que contiene los posibles errores de los objetos que llegaron desde la peticion al server
	// que posean la anotacion @Valid
	//De esta manera dentro del codigo se puede hacer un If con el metodo hasErrors de tipo boolean para identificar errores
	//para finalizar se tiene que usar el th en la vista
	@PostMapping("/newdegree")
	public ModelAndView newdegree(@Valid @ModelAttribute("degree") DegreeModel degree, BindingResult bindingResult ) {
		ModelAndView mV = new ModelAndView();
		if(bindingResult.hasErrors()) {
		mV.setViewName(ViewRouteHelper.DEGREE);
		}else {
			mV.setViewName(ViewRouteHelper.NEW_DEGREE);
			mV.addObject("degree", degree);
		}
		
		return mV;
	}
	
	
	
	
	
	}//fin home

