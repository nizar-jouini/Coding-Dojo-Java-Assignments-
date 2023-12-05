package com.nizar.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nizar.savetravels.models.Travel;
import com.nizar.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(Model model, @ModelAttribute("travel") Travel travel) {
		
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "expenses.jsp";
	}
	
	@PostMapping("/expenses")
	public String processCreateTravel(@Valid @ModelAttribute("travel") Travel travel,
								  BindingResult result) {
		
		if (result.hasErrors()) {
			return "expenses.jsp";
		}else {
			travelService.createTravel(travel);
		}
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String updateTravel(@PathVariable("id") Long id, Model model) {
		
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/edit/{id}")
	public String processUpdateTravel(@PathVariable("id") Long id, @Valid @ModelAttribute("travel") Travel travel,
			  						BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			travel.setId(id);	
			travelService.updateTravel(travel);
		}
		
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/expenses/delete/{id}") 
		
		public String destroy(@PathVariable("id") Long id) {
			
			travelService.deleteTravel(id);
			
			return "redirect:/expenses";
		}
	
	@GetMapping("/expenses/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		
		return "show.jsp";
	}
	
}
















