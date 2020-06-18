package com.example.gameofgamesserver.services;

import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.repositories.GameRepository;
import com.example.gameofgamesserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    GameRepository repository;

    public Game createGame(Game game) {
        return repository.save(game);
    }
}
