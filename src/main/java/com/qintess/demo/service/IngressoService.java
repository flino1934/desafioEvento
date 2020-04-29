package com.qintess.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.entity.Ingresso;
import com.qintess.demo.repositories.IngressoRepository;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository ingressoRepository;

	public List<Ingresso> findAll() {

		return ingressoRepository.findAll();
	}

	public Ingresso findById(Integer id) {

		ingressoRepository.findById(id);

		Optional<Ingresso> obj = ingressoRepository.findById(id);

		return obj.get();

	}

}
