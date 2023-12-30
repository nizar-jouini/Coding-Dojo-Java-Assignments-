package com.nizar.gameworkshop2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.gameworkshop2.models.Game;
import com.nizar.gameworkshop2.models.GameMechanic;
import com.nizar.gameworkshop2.services.GameMechanicService;
import com.nizar.gameworkshop2.services.GameService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GameMechanicController {

	@Autowired
	private GameMechanicService gameMechanicServ;
	
	@Autowired
	private GameService gameServ;
	
//	----------- Action Routes ---------------
//	Create Game
	@PostMapping("/gameMechanics/{id}/new")
	public String createGame(@PathVariable("id") Long id,
							Model model,
							@Valid @ModelAttribute("gameMechanic") GameMechanic gameMechanic,
							BindingResult result, HttpSession session) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			if (result.hasErrors()) {
				return "games/showGame.jsp";
			} else {
				
				Game thisGame = gameServ.findGame(id);
				gameMechanic.setGame(thisGame);
				
				// save the game in DB
				gameMechanicServ.createGameMechanic(gameMechanic);
				
				List<GameMechanic> gameMechanics = gameMechanicServ.allGameMechanics();
				model.addAttribute("gameMechanics", gameMechanics);

				return "redirect:/games/" + id;
			}
		}
	}

	
}












































