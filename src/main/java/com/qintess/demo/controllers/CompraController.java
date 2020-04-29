package com.qintess.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.demo.entity.Carrinho;
import com.qintess.demo.entity.Evento;
import com.qintess.demo.entity.Ingresso;
import com.qintess.demo.repositories.IngressoRepository;

@Controller
@RequestMapping("compras")
public class CompraController {

	@Autowired
	private IngressoRepository repository;

	@RequestMapping("/showFormforAddCompra")
	public String showFormforCompra(Model theModel) {

		Ingresso ingresso = new Ingresso();

		theModel.addAttribute("compra", ingresso);

		System.out.println("metodo showFormforCompra");

		return "compra";

	}

	@PostMapping("/saveCompra")
	public String saveCompra(@ModelAttribute("compra") Ingresso ingresso) {

		repository.save(ingresso);

		System.out.println("save compra");

		return "redirect:/eventos/list";

	}

}
