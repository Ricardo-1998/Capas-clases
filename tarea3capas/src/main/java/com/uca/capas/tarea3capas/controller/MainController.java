package com.uca.capas.tarea3capas.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	List <String> errores = new ArrayList<>();
	
	@RequestMapping("/ingresar")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("hora", Calendar.getInstance().getTime().toString());
		mav.setViewName("commons/index");
		return mav;
	}
	
	@RequestMapping("/parametros1")
	public ModelAndView parametros1(@RequestParam String nombre,@RequestParam String apellido, @RequestParam String fecha,
			@RequestParam String lnacimiento, @RequestParam String colegio, @RequestParam String tfijo, @RequestParam String tmovil) {
		ModelAndView mav = new ModelAndView();
		
		
		
		verificarErrores(verificarCantidadCadena(nombre,1,"nombre"),nombre);
		verificarErrores(verificarCantidadCadena(apellido,1,"apellido"),apellido);
		verificarErrores(verificarCantidadCadena(colegio,1,"Instituto o Colegio "),colegio);
		verificarErrores(verificarCantidadCadena(tfijo,2,"telefono fijo "),tfijo);
		verificarErrores(verificarCantidadCadena(tmovil,2,"telefono movil"),tmovil);
		verificarErrores(verificarCantidadCadena(lnacimiento,3,"lugar de nacimiento "),lnacimiento);
		verificarErrores(verificarFecha(fecha),fecha);
			
		if(errores.isEmpty()) {
			mav.addObject("nombre",nombre);
			mav.addObject("apellido",apellido);
			mav.addObject("fecha",fecha);
			mav.addObject("lnacimiento",lnacimiento);
			mav.addObject("colegio",colegio);
			mav.addObject("tfijo",tfijo);
			mav.addObject("tmovil",tmovil);
			mav.setViewName("commons/resultado");
			return mav;
		}else {
			mav.addObject("errores",errores);
			mav.setViewName("commons/errores");
			return mav;
		}
	}
	
	void verificarErrores(String cadenaV,String cadena) {
		if(cadenaV!=cadena) {
			errores.add(cadenaV);
		}
	}
	
	String verificarFecha(String fecha){
		String aux="fecha",aux2="";
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-mm-dd").parse("2003-01-01");
			Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
			if(date2.compareTo(date1)<0) {
		    	aux2="El campo "+ aux + "debe ser al menos mayor a 1/1/2003";
		    	return aux2;
		    }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return fecha;
	    
	}
	
	String verificarCantidadCadena(String cadena, int caso, String campo) {
		switch(caso) {
			case 1:
				if(cadena.length()<1) {
					cadena="El campo "+ campo + " debe ser de 1 caracter minimo";
				}
				else if(cadena.length()>25){
					cadena="El campo "+ campo + " debe ser menor o igual que 25 caracteres";
				}
				break;
			case 2:
				if(cadena.length()!=8) {
					cadena="El campo "+ campo + " debe ser de 8 caracteres exactos, usted ingreso "+ cadena.length()+" caracteres";
				}
				break;
			case 3:
				if(cadena.length()<1){
					cadena="El campo "+ campo + " debe ser de 1 caracter minimo";
				}
				if(cadena.length()>100) {
					cadena="El campo "+ campo + " debe ser menor o igual que 100 caracteres";
				}
				break;
		}
		
		return cadena;
	}
}
