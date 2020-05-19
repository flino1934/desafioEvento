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
import com.qintess.demo.entity.Evento;
import com.qintess.demo.exceptions.NotFoundException;
import com.qintess.demo.service.EventoService;

@RestController
@RequestMapping("/eventosresources")
public class EventoResource {

	@Autowired
	private EventoService service;

	@GetMapping("eventos")
	public ResponseEntity<List<Evento>> findAll() {

		List<Evento> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/eventos/{id}")
	public ResponseEntity<Evento> findById(@PathVariable Integer id) {

		Evento obj = service.findById(id);

		if (obj == null) {

			// Depois vamos adicionar uma exception nesta area

			throw new NotFoundException("Id do Evento não encontrado!");

		}

		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping("/eventos")
	public ResponseEntity<Evento> addEvento(@RequestBody Evento theEvento){
		
		theEvento.setId(0);
		service.save(theEvento);
		return ResponseEntity.ok().body(theEvento);
		
	}
	
	@PutMapping("/eventos")
	public ResponseEntity<Evento> updateEvento(@RequestBody Evento theEvento) {
		
		service.save(theEvento);
		
		return ResponseEntity.ok().body(theEvento);
		
	}
	
	@DeleteMapping("/eventos/{id}")
	public String deleteEvento(@PathVariable Integer id){
		
		Evento theEvento = service.findById(id);
		
		if (theEvento == null) {
			
			//Depois vamos adicionar uma exception nesta area
			
			throw new NotFoundException("Id do evento não encontrado!");
			
		}
		
		service.deleteById(id);
		
		return "Cliente deletado - "+theEvento.getDescricaoEvento()+" Id - "+id;
		
	}

}
