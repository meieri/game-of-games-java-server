package com.example.gameofgamesserver.services;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.Question;
import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.repositories.GameRepository;
import com.example.gameofgamesserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    @Autowired
    GameRepository repository;

    // Slightly hacky JSON parsing, because I really didn't want to write a deserializer
    public Game createGame(Map<String, Object> gameCategories, User currentUser) {

        Game newGame = new Game();
        newGame.setStart(new Date());
        newGame.setUser(currentUser);
        List<Category> newCategories = new ArrayList<Category>();
        List<Question> newQuestions = new ArrayList<Question>();

        for (Map.Entry<String, Object> entry : gameCategories.entrySet()) {
            Category newCategory = new Category();
            newCategory.setName(entry.getKey());

            ArrayList<Object> questions = (ArrayList<Object>) entry.getValue();
            for (Object q: questions) {
                Map<String, Object> questionValues = (Map<String, Object>) q;
                Question newQuestion = new Question();
                for (Map.Entry<String, Object> quesVal : questionValues.entrySet()) {
                    switch (quesVal.getKey()) {
                        case "question":
                            newQuestion.setQuestion((String)quesVal.getValue());
                            continue;
                        case "answer":
                            newQuestion.setAnswer((String)quesVal.getValue());
                            continue;
                        case "value":
                            newQuestion.setValue(Integer.valueOf((String) quesVal.getValue()));
                            continue;
                        default:
                            continue;
                    }
                }
                if (newQuestion != null) {
                    newQuestions.add(newQuestion);
                }
            }
            if (newCategory != null) {
                newCategories.add(newCategory);
            }
        }
        System.out.println(newCategories);
        System.out.println(newGame);
        newGame.setCategories(newCategories);
        return repository.save(newGame);
    }
}
