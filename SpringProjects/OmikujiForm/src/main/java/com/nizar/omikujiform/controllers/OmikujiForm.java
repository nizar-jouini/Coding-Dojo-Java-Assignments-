package com.nizar.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikujiForm {

	@GetMapping("/")
	public String index() {

		return "redirect:/omikuji";
	}

	@GetMapping("/omikuji")
	public String omikuji() {

		return "index.jsp";
	}

	@PostMapping("/omikuji/add")
	public String add(@RequestParam(value = "number") Integer number, @RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person, @RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "living") String living, @RequestParam(value = "message") String message,
			HttpSession session) {

		String resultOmikuji = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, hobby, living, message);

		session.setAttribute("resultOmikuji", resultOmikuji);

		return "redirect:/omikuji/show";
	}

	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {

		String result = (String) session.getAttribute("resultOmikuji");

		model.addAttribute("result", result);

		return "show.jsp";
	}

}
