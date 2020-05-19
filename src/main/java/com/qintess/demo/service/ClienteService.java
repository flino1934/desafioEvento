package com.qintess.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.entity.Cliente;
import com.qintess.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	public Cliente findById(Integer id) {

		clienteRepository.findById(id);

		Optional<Cliente> obj = clienteRepository.findById(id);

		return obj.get();

	}
	
	public void save(Cliente theCliente) {
		
		clienteRepository.save(theCliente);
		
	}
	
	public void deleteById(int theId) {
		
		clienteRepository.deleteById(theId);
		
	}

}
