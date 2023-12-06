package com.nizar.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.dojosandninjas.models.Dojo;
import com.nizar.dojosandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	
	//--------Get Routes-----------
	@GetMapping("/")
	public String index(Model model) {
		
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		
		return "Dojo/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "Dojo/newDojo.jsp";
	}
	
	@GetMapping("/dojos/show/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		
		Dojo dojo = dojoService.findOneDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "Dojo/showDojo.jsp";
	}
	
	//--------Post Routes-----------
	@PostMapping("/dojos/new")
	public String creatDojo(@ Valid @ModelAttribute("dojo") Dojo dojo,
			  				BindingResult result) {
		
		if (result.hasErrors()) {
			return "Dojo/newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
		}
		
		return "redirect:/";
		
	}
	
}














