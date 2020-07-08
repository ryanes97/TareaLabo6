package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

public interface ContribuyenteService {
	
	public List<Importancia> getListaDeImportancias() throws DataAccessException;
	
	public List<Contribuyente> getAll() throws DataAccessException;
	
	public void save(Contribuyente contribuyente) throws DataAccessException;

}
