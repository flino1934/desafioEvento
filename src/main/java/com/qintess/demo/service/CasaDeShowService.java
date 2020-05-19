package com.qintess.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.demo.entity.CasaDeShow;
import com.qintess.demo.repositories.CasaDeShowRepository;

@Service
public class CasaDeShowService {

	@Autowired
	private CasaDeShowRepository casaDeShowRepository;

	public List<CasaDeShow> findAll() {

		return casaDeShowRepository.findAll();
	}

	public CasaDeShow findById(Integer id) {

		casaDeShowRepository.findById(id);

		Optional<CasaDeShow> obj = casaDeShowRepository.findById(id);

		return obj.get();

	}

	public void save(CasaDeShow theCasaDeShow) {

		casaDeShowRepository.save(theCasaDeShow);

	}

	
	
	public void deleteById(int theId) {

		casaDeShowRepository.deleteById(theId);

	}

}
