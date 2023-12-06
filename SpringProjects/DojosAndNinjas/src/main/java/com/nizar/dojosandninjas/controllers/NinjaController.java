package com.nizar.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.dojosandninjas.models.Dojo;
import com.nizar.dojosandninjas.models.Ninja;
import com.nizar.dojosandninjas.services.DojoService;
import com.nizar.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	@Autowired
	NinjaService ninjaService;

	@Autowired
	DojoService dojoService;

	// --------Get Routes-----------
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {

		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);

		return "Ninja/newNinja.jsp";
	}

	// --------Post Routes-----------
	@PostMapping("/ninja/new")
	public String creatNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
							BindingResult result) {
		if (result.hasErrors()) {
			return "Ninja/newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
		}

		return "redirect:/";

	}

}













