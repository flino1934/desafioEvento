package com.qintess.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.demo.entity.Evento;
import com.qintess.demo.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoRepository repository;

	@GetMapping("/list")
	public String listEvento(Model theModel) {

		// get the evento from the dao

		List<Evento> theEventos = repository.findAll();

		// add atribute

		theModel.addAttribute("evento", theEventos);

		System.out.println("Lista de eventos");

		return "list-evento";
	}

	@GetMapping("/showFormForAddEvento")
	public String showFormForAdd(Model theModel) {

		System.out.println("ola showFormForAddEvento");

		Evento theEvento = new Evento();

		theModel.addAttribute("evento", theEvento);

		return "evento-form";

	}
	
	@PostMapping("/saveEvento")
	public String saveCliente(@ModelAttribute("evento") Evento theEvento) {

		repository.save(theEvento);

		return "redirect:/eventos/list";

	}

}
