package com.example.gameofgamesserver.controllers;

import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class GameController {
    @Autowired
    GameService service;

    @PostMapping("/api/game")
    public Game createGame(@RequestBody Game game) {
        //User currentUser = (User)session.getAttribute("currentUser");
        // If this gets parsed automatically it will be a fucking miracle
        //game.setUser(currentUser);
        game.setStart(new Date());
        return service.createGame(game);
    }
}
