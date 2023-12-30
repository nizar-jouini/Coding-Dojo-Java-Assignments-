package com.nizar.gameworkshop2.controllers;

import java.util.Collections;
import java.util.Comparator;
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

import com.nizar.gameworkshop2.models.Game;
import com.nizar.gameworkshop2.models.GameMechanic;
import com.nizar.gameworkshop2.models.User;
import com.nizar.gameworkshop2.services.GameMechanicService;
import com.nizar.gameworkshop2.services.GameService;
import com.nizar.gameworkshop2.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GameController {

	@Autowired
	private GameService gameServ;

	@Autowired
	private UserService userServ;

	@Autowired
	private GameMechanicService gameMechanicServ;

//	----------- Display Routes ---------------
//	Display all games
	@GetMapping("/games")
	public String games(Model model, @ModelAttribute("game") Game game, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			User user = userServ.findById(userId);
			model.addAttribute("user", user);

			List<Game> all_games = gameServ.allGames();
			// Sort the list by name using a custom comparator
			Collections.sort(all_games, Comparator.comparing(Game::getName));
			model.addAttribute("games", all_games);

			return "games/home.jsp";
		}

	}

//	Display create game page
	@GetMapping("/games/new")
	public String newBook(@ModelAttribute("game") Game game, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			return "games/newGame.jsp";
		}

	}

//	Display a game details
	@GetMapping("/games/{id}")
	public String oneGame(@PathVariable("id") Long id, Model model,
						  @ModelAttribute("gameMechanic") GameMechanic gameMechanic,
							HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			List<GameMechanic> gameMechanics = gameMechanicServ.allGameMechanics();
			Game oneGame = gameServ.findGame(id);
			model.addAttribute("gameMechanics", gameMechanics);
			model.addAttribute("oneGame", oneGame);
			model.addAttribute("logedUserId", userId);

		}

		return "games/showGame.jsp";
	}

//	Display update a game page
	@GetMapping("/games/{id}/edit")
	public String updateBook(@PathVariable("id") Long id, Model model, @ModelAttribute("game") Game game,
			HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			Game thisGame = gameServ.findGame(id);
			model.addAttribute("oneGame", thisGame);

			return "games/updateGame.jsp";
		}

	}

//	----------- Action Routes ---------------
//	Create Game
	@PostMapping("/games/new")
	public String createGame(@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			if (result.hasErrors()) {
				return "games/newGame.jsp";
			} else {
				Long UserID = (Long) session.getAttribute("user_id");

				User loggedinUser = userServ.findById(UserID);
				game.setUser(loggedinUser);

				try {
					// save the game in DB
					gameServ.createGame(game);
				} catch (Exception e) {
					// Handle uniqueness violation exception
					result.rejectValue("name", "error.name", "This Name is Used, Choose another");
					return "games/newGame.jsp";
				}
				return "redirect:/games";
			}
		}
	}

//	Update Game
	@PutMapping("/games/{id}/edit")
	public String updateThisBook(@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {

		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {

			if (result.hasErrors()) {
				return "games/updateGame.jsp";
			} else {

				User user = userServ.findById(userId);
				game.setUser(user);
				gameServ.updateGame(game);

				return "redirect:/games";
			}
		}

	}

//	Delete Game
	@DeleteMapping("/games/{id}/delete")
	public String delete(@PathVariable("id") Long id) {

		gameServ.deleteGame(id);

		return "redirect:/games";
	}

}
