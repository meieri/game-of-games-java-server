package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
