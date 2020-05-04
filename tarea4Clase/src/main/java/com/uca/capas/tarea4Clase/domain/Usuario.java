package com.uca.capas.tarea4Clase.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {
	
	@Size(min=1, max=25)
	String usuario;
	
	@NotEmpty
	String contrasenia;
	
	

	public Usuario() {
	}

	public Usuario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
	
}
