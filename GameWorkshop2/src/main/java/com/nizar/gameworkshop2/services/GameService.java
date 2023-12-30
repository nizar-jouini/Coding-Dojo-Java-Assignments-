package com.nizar.gameworkshop2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizar.gameworkshop2.models.Game;
import com.nizar.gameworkshop2.repositories.GameRepository;

@Service
public class GameService {

//	C R U D

	@Autowired
	private GameRepository gameRepo;

//	READ ALL
	public List<Game> allGames() {		
		return gameRepo.findAll();
	}

//	CREATE
	public Game createGame(Game g) {
		return gameRepo.save(g);
	}

//	READ ONE
	public Game findGame(Long id) {
		Optional<Game> maybeGame = gameRepo.findById(id);
		if (maybeGame.isPresent()) {
			return maybeGame.get();
		} else {
			return null;
		}
	}

//	UPDATE A GAME
	public Game updateGame(Game g) {
		return gameRepo.save(g);
	}

//	DELETE A GAME
	public void deleteGame(Long id) {
		gameRepo.deleteById(id);
	}
	

}
