package com.qintess.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {//esta herdando de uma interface pronta 

}
