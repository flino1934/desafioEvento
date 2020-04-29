package com.qintess.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.demo.entity.Evento;
import com.qintess.demo.repositories.EventoRepository;

@Controller
public class IndexController {
	
	@Autowired
	private EventoRepository repository;

	@RequestMapping("")
	public String carregarIndex(Model theModel) {

		System.out.println("Carregando o mapeamento index");

		List<Evento> theEventos = repository.findAll();

		// add atribute

		theModel.addAttribute("evento", theEventos);

		System.out.println("Lista de eventos");

		return "index";

	}

}
