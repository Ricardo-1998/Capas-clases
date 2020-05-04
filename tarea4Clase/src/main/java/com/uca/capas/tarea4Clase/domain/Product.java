package com.uca.capas.tarea4Clase.domain;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
	@Size(min=12, max =12, message="El codigo debe ser de 12 caracteres exactos")
	String codigo;
	@Size(min=1, max =100)
	String nombre;
	@Size(min=1, max =100)
	String marca;
	@Size(min=1, max =500)
	String descripcion;
	
	@Digits(integer=10, fraction=0, message = "Se esperaba numeros enteros!")
	String existencias;
	
	@Pattern(regexp = "(([1-2][0-9])|([1-9])|(3[0-1]))/((1[0-2])|([1-9]))/[0-9]{4}", message = "fecha mal puesta debe ser dd/mm/yyyy")
	String fIngreso;

	
	
	public Product() {
		super();
	}
	
	

	public Product(@Size(min = 12, max = 12, message="El codigo debe ser de 12 caracteres exactos") String codigo, @Size(min = 1, max = 100) String nombre,
			@Size(min = 1, max = 100) String marca, @Size(min = 1, max = 500) String descripcion,
			@Digits(integer = 10, fraction = 0, message = "Se esperaba numeros enteros!") String existencias,
			@Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))") String fIngreso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.existencias = existencias;
		this.fIngreso = fIngreso;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExistencias() {
		return existencias;
	}

	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}

	public String getfIngreso() {
		return fIngreso;
	}

	public void setfIngreso(String fIngreso) {
		this.fIngreso = fIngreso;
	}
	
	
	
}

