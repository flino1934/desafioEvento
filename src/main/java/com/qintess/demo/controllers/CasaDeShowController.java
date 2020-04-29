package com.qintess.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qintess.demo.entity.CasaDeShow;
import com.qintess.demo.repositories.CasaDeShowRepository;

@Controller
@RequestMapping("/casaDeShow")
public class CasaDeShowController {

	@Autowired
	private CasaDeShowRepository casaDeShowRepository;

	@RequestMapping("/list")
	public String listaCasaDeshow(Model theModel) {

		List<CasaDeShow> theCasa = casaDeShowRepository.findAll();

		theModel.addAttribute("casa", theCasa);

		System.out.println("Entrou no metodo mostrar lista do listaCasaDeshow");

		return "list-casa";

	}

	@GetMapping("/showFormForAddCasaDeShow")
	public String showFormForAddCasaDeShow(Model theModel) {

		System.out.println("acessou o metodo showFormForAddCasaDeShow");

		CasaDeShow thecCasa = new CasaDeShow();

		theModel.addAttribute("casa", thecCasa);

		return "casa-form";

	}

	@PostMapping("/saveCasaDeShow")
	public String saveCasaDeShow(@ModelAttribute("casa") CasaDeShow theCasa) {

		casaDeShowRepository.save(theCasa);

		return "redirect:/casaDeShow/list";

	}

	@GetMapping("/delete")
	public String deleteCasaDeShowr(@RequestParam("casaId") int theId) {

		// delete the cliente

		casaDeShowRepository.deleteById(theId);

		return "redirect:/casaDeShow/list";

	}

}
