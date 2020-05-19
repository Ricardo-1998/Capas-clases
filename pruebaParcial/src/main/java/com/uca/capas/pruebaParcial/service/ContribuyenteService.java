package com.uca.capas.pruebaParcial.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.pruebaParcial.domain.Contribuyente;

public interface ContribuyenteService {
	
	public List<Contribuyente> findAll() throws DataAccessException;

	
	public void save(Contribuyente contribuyente) throws DataAccessException;
}
