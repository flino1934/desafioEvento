package com.qintess.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.demo.entity.CasaDeShow;

public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer> {//esta herdando de uma interface pronta 

}
