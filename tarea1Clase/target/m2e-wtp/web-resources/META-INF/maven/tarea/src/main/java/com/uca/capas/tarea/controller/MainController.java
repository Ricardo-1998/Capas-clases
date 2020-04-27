package com.uca.capas.tarea.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/informacion")
	public @ResponseBody String informacion() {
		String nombre ="Ricardo<br>", apellido="Villeda<br>", carnet="00004817<br>", carrera="Informatica<br>",anio="4<br>";
		return "Nombre: " + nombre +" Apellido: "+ apellido+" Carnet: "+ carnet +" Carrera: "+carrera+ " Año: "+ anio;
		
	}
	
	
	@RequestMapping("/fecha")
	public @ResponseBody String fecha(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(anio,mes-1,dia);
		Integer param=calendario.get(Calendar.DAY_OF_WEEK);
		
		
		String nDia="no se encontro";
		
		switch (param) {
			case 1: nDia= "Domingo";
			break;
			case 2: nDia= "Lunes";
			break;
			case 3: nDia= "Martes";
			break;
			case 4: nDia= "Miercoles";
			break;
			case 5: nDia= "Jueves";
			break;
			case 6: nDia= "Viernes";
			break;
			case 7: nDia= "Sabado";
			break;
		}
		//ejemplo http://localhost:8080/fecha?dia=16&mes=4&anio=2020
		return "La fecha: " + dia+"/"+mes+"/"+anio+"  fue dia: " + nDia;
	}
}


