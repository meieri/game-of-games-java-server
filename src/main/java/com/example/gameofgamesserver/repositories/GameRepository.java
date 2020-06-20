package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Query("SELECT game FROM Game game WHERE game.user.id = :userId")
    public List<Game> findGameByUserId(@Param("userId") Integer uid);
}
