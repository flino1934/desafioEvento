package com.qintess.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.entity.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {//esta herdando de uma interface pronta 

}
