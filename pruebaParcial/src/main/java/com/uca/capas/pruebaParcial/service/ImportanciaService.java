package com.uca.capas.pruebaParcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.pruebaParcial.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia> findAll() throws DataAccessException;


}
