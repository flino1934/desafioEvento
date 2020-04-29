package com.qintess.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.entity.Evento;
import com.qintess.demo.repositories.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	public List<Evento> findAll() {

		return eventoRepository.findAll();
	}

	public Evento findById(Integer id) {

		eventoRepository.findById(id);

		Optional<Evento> obj = eventoRepository.findById(id);

		return obj.get();

	}

}
