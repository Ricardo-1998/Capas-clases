package com.uca.capas.parcial.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial.domain.Categoria;
import com.uca.capas.parcial.domain.Libro;
import com.uca.capas.parcial.service.CategoriaService;
import com.uca.capas.parcial.service.LibroService;





@Controller
public class MainController {
	@Autowired
	LibroService libroService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mensaje", "");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/IngCategoria")
	public ModelAndView ingresarCat() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria =  new Categoria();
		mav.addObject("categoria",categoria);
		mav.setViewName("Categoria");
		return mav;
	}
	
	@RequestMapping("/formCategoria")
	public ModelAndView formulario(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("Categoria");
		}
		else {
			try {
				categoriaService.save(categoria);
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("mensaje", "Se guardo la categoria con exito con exito");
			mav.setViewName("index");
		}
		return mav;
	}
	
	
	@RequestMapping("/IngLibro")
	public ModelAndView ingresarLib() {
		ModelAndView mav = new ModelAndView();
		Libro libro =  new Libro();
		List<Categoria> categorias= null;
		try {
			categorias =  categoriaService.findAll();
			
		}catch(Exception e) {
			mav.addObject("mensaje","Por el momento no hay categorias disponibles");
			e.printStackTrace();
		}
		mav.addObject("libro",libro);
		mav.addObject("categorias",categorias);
		mav.setViewName("libro");
		return mav;
	}
	
	
	@RequestMapping("/formLibro")
	public ModelAndView formulario(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Categoria> categorias= null;
			try {
				categorias =  categoriaService.findAll();
				mav.addObject("categorias",categorias);
			}catch(Exception e) {
				mav.addObject("mensaje","Por el momento no hay categorias disponibles");
				e.printStackTrace();
			}
			mav.setViewName("libro");
		}
		else {
			SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH'h'MM'min'");
			Date date = new Date(System.currentTimeMillis());
		    libro.setF_ingreso(date);
		    
		   try {
			   if(libro.getB_estado()==null) {
				   libro.setB_estado(false);
			   }
			   libroService.save(libro);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		    
		   mav.addObject("mensaje","El libro fue guardado con exito");
		   mav.setViewName("index");
		}		
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros =null;
		
		try {
			libros=libroService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("libros");
		return mav;
	}
}
