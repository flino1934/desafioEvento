package com.qintess.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {//esta herdando de uma interface pronta 

	

	

}
