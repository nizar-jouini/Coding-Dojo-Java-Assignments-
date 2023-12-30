package com.nizar.gameworkshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nizar.gameworkshop.models.Game;
import com.nizar.gameworkshop.models.GameMechanic;
import com.nizar.gameworkshop.models.User;
import com.nizar.gameworkshop.services.GameMechanicService;
import com.nizar.gameworkshop.services.GameService;
import com.nizar.gameworkshop.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GameMechanicController {

	@Autowired
	private GameMechanicService gameMechanicServ;
	
	@Autowired
	private GameService gameServ;
	
	@Autowired
	private UserService userServ;
	
//	----------- Action Routes ---------------
//	Create Game Mechanic
	@PostMapping("/gameMechanics/{id}/new")
	public String createGame(@PathVariable("id") Long id,
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
				
				User loggedinUser = userServ.findById(userId);
				gameMechanic.setUser(loggedinUser);

				// save the game in DB
				gameMechanicServ.createGameMechanic(gameMechanic);
				
				return "redirect:/games/" + id;
			}
		}
	}
	
//	Delete Game Mechanic
	@DeleteMapping("games/{gameId}/gameMechanics/{gameMechanicId}/delete")
	public String delete(@PathVariable("gameMechanicId") Long gameMechanicId,
						 @PathVariable("gameId") Long gameId) {
		
		gameMechanicServ.deleteGameMechanic(gameMechanicId);
		
		return "redirect:/games/" + gameId;
		
	}

	
}












































