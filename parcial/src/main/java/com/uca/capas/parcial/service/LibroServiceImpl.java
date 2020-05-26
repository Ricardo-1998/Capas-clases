package com.uca.capas.parcial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial.dao.LibroDAO;
import com.uca.capas.parcial.domain.Libro;


@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	LibroDAO libroDao;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.findAll();
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.findOne(code);
	}

	@Override
	public void save(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDao.save(libro);
	}
}
