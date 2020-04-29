package com.qintess.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.demo.entity.CasaDeShow;
import com.qintess.demo.service.CasaDeShowService;

@RestController
@RequestMapping("/casas")
public class CasaDeShowResource {

	@Autowired
	private CasaDeShowService service;

	@GetMapping
	public ResponseEntity<List<CasaDeShow>> findAll() {

		List<CasaDeShow> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CasaDeShow> findById(@PathVariable Integer id) {

		CasaDeShow obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

}
