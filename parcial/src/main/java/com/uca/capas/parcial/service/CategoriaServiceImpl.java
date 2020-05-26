package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial.dao.CategoriaDAO;
import com.uca.capas.parcial.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaDAO categoriaDao;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.findOne(code);
	}

	@Override
	public void save(Categoria categoria) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDao.save(categoria);
	}



}
