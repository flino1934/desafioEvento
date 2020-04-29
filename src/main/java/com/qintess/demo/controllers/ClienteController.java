package com.qintess.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.demo.entity.Cliente;
import com.qintess.demo.repositories.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/list")
	public String listaCliente(Model theModel) {

		// get the cliente from the dao

		List<Cliente> theClientes = clienteRepository.findAll();

		// add the customer to the model

		theModel.addAttribute("clientes", theClientes);// name value

		System.out.println("Nova requisição");

		return "list-cliente";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		System.out.println("ola showFormForAdd");

		Cliente theCliente = new Cliente();

		theModel.addAttribute("cliente", theCliente);

		return "cliente-form";

	}

	@PostMapping("/saveCliente")
	public String saveCliente(@ModelAttribute("cliente") Cliente theCliente) {

		clienteRepository.save(theCliente);

		return "redirect:/clientes/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormforUpdate(@RequestParam("clienteId") int theId, Model theModel) {

		// get the cliente from the database

		Optional<Cliente> theCliente = clienteRepository.findById(theId);

		// set customer as a model atribute to pre- populate the form

		theModel.addAttribute("cliente", theCliente);

		// send over to our form

		return "cliente-form";

	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("clienteId") int theId) {

		// delete the cliente

		clienteRepository.deleteById(theId);

		return "redirect:/clientes/list";

	}

}
