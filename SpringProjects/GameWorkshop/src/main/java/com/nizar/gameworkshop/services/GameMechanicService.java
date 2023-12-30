package com.nizar.gameworkshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizar.gameworkshop.models.Game;
import com.nizar.gameworkshop.models.GameMechanic;
import com.nizar.gameworkshop.repositories.GameMechanicRepository;

@Service
public class GameMechanicService {

//	C R U D

	@Autowired
	private GameMechanicRepository gameMechanicRepo;

//	READ ALL Game Mechanics
	public List<GameMechanic> allGameMechanics() {		
		return gameMechanicRepo.findAll();
	}
	
//	READ ALL Game Mechanics By Game Id
	public List<GameMechanic> GameMechanicsByGame(Game game) {
		return gameMechanicRepo.getGameMechanicsByGameId(game);
	}

//	CREATE Game Mechanic
	public GameMechanic createGameMechanic(GameMechanic gm) {
		return gameMechanicRepo.save(gm);
	}

//	DELETE A Game Mechanic
	public void deleteGameMechanic(Long id) {
		gameMechanicRepo.deleteById(id);
	}
}


















