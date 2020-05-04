package com.uca.capas.tarea4Clase.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea4Clase.domain.Product;


@Controller
public class MainController {

	@RequestMapping("/producto")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new Product());
		mav.setViewName("productoV");
		return mav;
	}
	
	
	@RequestMapping("/procesar")
	public ModelAndView procesar(@Valid @ModelAttribute Product producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("productoV");
		}else {
			mav.addObject("nombre", producto.getNombre());
			mav.setViewName("resultado");
			
		}	
		return mav;
	}
	
}
