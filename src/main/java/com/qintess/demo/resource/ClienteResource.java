package com.qintess.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.demo.entity.Cliente;
import com.qintess.demo.exceptions.NotFoundException;
import com.qintess.demo.service.ClienteService;

@RestController
@RequestMapping("/clientesresources")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping("clientes")
	public ResponseEntity<List<Cliente>> findAll() {

		List<Cliente> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}	
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {

		Cliente obj = service.findById(id);
		
		if (obj == null) {
			
			//Depois vamos adicionar uma exception nesta area 
			
			throw new NotFoundException("Id do cliente não encontrado!");
			
		}

		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente theCliente){
		
		theCliente.setId(0);
		service.save(theCliente);
		return ResponseEntity.ok().body(theCliente);
		
	}
	
	@PutMapping("/clientes")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente theCliente) {
		
		service.save(theCliente);
		
		return ResponseEntity.ok().body(theCliente);
		
	}
	
	@DeleteMapping("/clientes/{id}")
	public String deleteCliente(@PathVariable Integer id){
		
		Cliente theCliente = service.findById(id);
		
		if (theCliente == null) {
			
			//Depois vamos adicionar uma exception nesta area
			
			throw new NotFoundException("Id do cliente não encontrado!");
			
		}
		
		service.deleteById(id);
		
		return "Cliente deletado - "+theCliente.getFirstName()+" Id - "+id;
		
	}

}
