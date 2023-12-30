package com.nizar.gameworkshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nizar.gameworkshop.models.Game;
import com.nizar.gameworkshop.models.GameMechanic;

@Repository
public interface GameMechanicRepository extends CrudRepository<GameMechanic, Long> {

//	Read ALL
	List<GameMechanic> findAll();
	
//	Get ALL Game Mechanics By Game Id
	@Query("SELECT GM FROM GameMechanic GM WHERE game = ?1")
	List<GameMechanic> getGameMechanicsByGameId(Game game);
}
