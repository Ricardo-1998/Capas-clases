package com.uca.capas.pruebaParcial.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.pruebaParcial.dao.ContribuyenteDAO;
import com.uca.capas.pruebaParcial.dao.ImportanciaDAO;
import com.uca.capas.pruebaParcial.domain.Contribuyente;
import com.uca.capas.pruebaParcial.domain.Importancia;

@Controller
public class MainController {
	
	@Autowired
	ImportanciaDAO importanciaDao;
	
	@Autowired
	ContribuyenteDAO contribuyenteDao;
	

	
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente =  new Contribuyente();
		List<Importancia> importancias= null;
		try {
			importancias =  importanciaDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyente",contribuyente);
		mav.addObject("importancias",importancias);
		mav.setViewName("index");
		return mav;

	}
	
	@RequestMapping("/formContribuyente")
	public ModelAndView formulario(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {

			List<Importancia> importancias= null;
			try {
				importancias =  importanciaDao.findAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("importancias",importancias);
			mav.setViewName("index");
		}
		else {
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    Date dateobj = new Date();
		    contribuyente.setF_fecha_ingreso(dateobj);
		    
		   
		    contribuyenteDao.save(contribuyente);

			mav.setViewName("resultado");
		}
		
		
		return mav;

	}
	
	@RequestMapping("/verContribuyentes")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes =null;
		
		contribuyentes=contribuyenteDao.findAll();
		
		System. out. println(contribuyentes.get(6).getC_importancia().getS_importancia().toString());
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		
		return mav;

	}
	
}
