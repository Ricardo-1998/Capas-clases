package com.uca.capas.pruebaParcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.pruebaParcial.dao.ContribuyenteDAO;
import com.uca.capas.pruebaParcial.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService{
	
	@Autowired
	ContribuyenteDAO contribuyenteDao;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDao.findAll();
	}



	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDao.save(contribuyente);
	}

}
