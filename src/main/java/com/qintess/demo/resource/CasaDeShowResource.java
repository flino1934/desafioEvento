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

import com.qintess.demo.entity.CasaDeShow;
import com.qintess.demo.entity.Cliente;
import com.qintess.demo.exceptions.NotFoundException;
import com.qintess.demo.service.CasaDeShowService;

@RestController
@RequestMapping("/casasresources")
public class CasaDeShowResource {

	@Autowired
	private CasaDeShowService service;

	@GetMapping("/casas")
	public ResponseEntity<List<CasaDeShow>> findAll() {

		List<CasaDeShow> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/casas/{id}")
	public ResponseEntity<CasaDeShow> findById(@PathVariable Integer id) {

		CasaDeShow obj = service.findById(id);

		if (obj == null) {

			throw new NotFoundException("Id do casa não encontrado!");

		}

		return ResponseEntity.ok().body(obj);

	}

	@PostMapping("/casas")
	public ResponseEntity<CasaDeShow> addCasaDeShow(@RequestBody CasaDeShow theCasaDeShow) {

		theCasaDeShow.setId(0);
		service.save(theCasaDeShow);

		return ResponseEntity.ok().body(theCasaDeShow);

	}

	@PutMapping("/casas")
	public ResponseEntity<CasaDeShow> updateCasaDeshow(@RequestBody CasaDeShow theCasaDeShow) {
		
		service.save(theCasaDeShow);
		
		return ResponseEntity.ok().body(theCasaDeShow);
		
	}
	
	@DeleteMapping("/casas/{id}")
	public String deleteCasaDeShow(@PathVariable Integer id){
		
		CasaDeShow theCasaDeShow = service.findById(id);
		
		if (theCasaDeShow == null) {
			
			//Depois vamos adicionar uma exception nesta area
			
			throw new NotFoundException("Id do casa não encontrado!");
			
		}
		
		service.deleteById(id);
		
		return "Casa de show deletada - "+theCasaDeShow.getNomeCasaShow()+" Id - "+id;
		
	}

}
