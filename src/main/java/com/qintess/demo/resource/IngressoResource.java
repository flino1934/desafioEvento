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

import com.qintess.demo.entity.Evento;
import com.qintess.demo.entity.Ingresso;
import com.qintess.demo.exceptions.NotFoundException;
import com.qintess.demo.service.IngressoService;

@RestController
@RequestMapping("/ingressosresources")
public class IngressoResource {

	@Autowired
	private IngressoService service;

	@GetMapping("/ingressos")
	public ResponseEntity<List<Ingresso>> findAll() {

		List<Ingresso> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/ingressos/{id}")
	public ResponseEntity<Ingresso> findById(@PathVariable Integer id) {

		Ingresso obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping("/ingressos")
	public ResponseEntity<Ingresso> addIngresso(@RequestBody Ingresso theIngresso){
		
		theIngresso.setId(0);
		service.save(theIngresso);
		return ResponseEntity.ok().body(theIngresso);	
	}
	
	@PutMapping("/ingressos")
	public ResponseEntity<Ingresso> updateEvento(@RequestBody Ingresso theIngresso) {
		
		service.save(theIngresso);
		
		return ResponseEntity.ok().body(theIngresso);
		
	}
	
	@DeleteMapping("/ingressos/{id}")
	public String deleteEvento(@PathVariable Integer id){
		
		Ingresso theIngresso = service.findById(id);
		
		if (theIngresso == null) {
			
			//Depois vamos adicionar uma exception nesta area
			
			throw new NotFoundException("Id do ingresso não encontrado!");
			
		}
		
		service.deleteById(id);
		
		return "Ingresso deletado id - "+id;
		
	}

}
