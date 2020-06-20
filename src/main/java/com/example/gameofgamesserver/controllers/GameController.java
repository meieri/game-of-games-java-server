package com.example.gameofgamesserver.controllers;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.Question;
import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class GameController {
    @Autowired
    GameService service;

    @PostMapping("/api/game")
    public Game createGame(@RequestBody Map<String, Object> gameCategories, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        return service.createGame(gameCategories, currentUser);
    }

    @PostMapping("api/game/{gameId}")
    public Game findGameById(@PathVariable("gameId") Integer gameId) {
        return service.findGameById(gameId);
    }
}
