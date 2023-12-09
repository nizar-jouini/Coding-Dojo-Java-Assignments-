package com.nizar.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.bookclub.models.Author;
import com.nizar.bookclub.services.AuthorService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorServ;

//	----------- Display Routes ---------------
//	Display create author page
	@GetMapping("/authors/new")
	public String newAuthor(@ModelAttribute("author") Author author,
							HttpSession session) {
// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

		return "Authors/newAuthor.jsp";
		}
	}
	
//	----------- Action Routes ---------------
//	Create Author
	@PostMapping("/authors/new")
	public String createAuthor(@Valid @ModelAttribute("author") Author author,
								BindingResult result, HttpSession session) {
// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
		
			if (result.hasErrors()) {
				return "Authors/newAuthor.jsp";
			} else {
				authorServ.createAuthor(author);
			}
		}
		return "redirect:/books/new";
	}
}






















