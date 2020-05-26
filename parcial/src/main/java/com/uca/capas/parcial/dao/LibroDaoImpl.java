package com.uca.capas.parcial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial.domain.Libro;

@Repository
public class LibroDaoImpl implements LibroDAO{

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query= entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro>resultset=query.getResultList();
		return resultset;
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		Libro libro = entityManager.find(Libro.class,code);
		return libro;
	}

	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		if(libro.getC_libro() ==null) { 
			entityManager.persist(libro);
		}
		else { 
			entityManager.merge(libro); 
		}
		
	}

	

}
