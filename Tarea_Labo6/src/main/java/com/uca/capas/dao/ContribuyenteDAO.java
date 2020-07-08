package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;

public interface ContribuyenteDAO {
	
	public List<Contribuyente> getAll() throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;
}
