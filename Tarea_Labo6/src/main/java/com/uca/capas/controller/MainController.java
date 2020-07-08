package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;

@Controller
public class MainController 
{
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@RequestMapping("/")
	public ModelAndView initMain() 
	{
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> listaDeImportancia = null;
		
		try {
			listaDeImportancia = contribuyenteService.getListaDeImportancias();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", listaDeImportancia);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/guardarContribuyente")
	public ModelAndView save(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			List<Importancia> listaDeImportancia = null;
			
			try {
				listaDeImportancia = contribuyenteService.getListaDeImportancias();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("importancias", listaDeImportancia);
			mav.setViewName("index");
		}
		else 
		{
			contribuyenteService.save(contribuyente);
			mav.setViewName("exito");
		}
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		try {
			contribuyentes = contribuyenteService.getAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		
		return mav;
	}
	
}
