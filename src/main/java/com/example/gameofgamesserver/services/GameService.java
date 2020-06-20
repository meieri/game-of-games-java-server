package com.example.gameofgamesserver.services;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.Question;
import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.repositories.GameRepository;
import com.example.gameofgamesserver.repositories.QuestionRepository;
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
    @Autowired
    CategoryService categoryService;
    @Autowired
    QuestionService questionService;

    // Slightly hacky JSON parsing, because I really didn't want to write a deserializer
    public Game createGame(Map<String, Object> gameCategories, User currentUser) {

        Game newGame = new Game();
        newGame.setStart(new Date());
        newGame.setUser(currentUser);
        newGame = repository.save(newGame);

        List<Category> newCategories = new ArrayList<Category>();
        List<Question> newQuestions = new ArrayList<Question>();

        for (Map.Entry<String, Object> entry : gameCategories.entrySet()) {
            Category newCategory = new Category();
            newCategory.setName(entry.getKey());
            categoryService.createCategory(newCategory, newGame);

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
                    questionService.createQuestion(newQuestion, newCategory);
                    newQuestions.add(newQuestion);
                }
            }
            if (newCategory != null) {
                newCategories.add(newCategory);
            }
        }
        newGame.setCategories(newCategories);
        return newGame;
    }

    public Game findGameById(Integer id) {
        Game game = repository.findById(id).get();
        List<Category> categories = categoryService.findCategoriesForGame(id);
        for (Category currCat : categories) {
            List<Question> questions = questionService.getQuestionsForCategory(currCat.getId());
            currCat.setQuestions(questions);
        }
        game.setCategories(categories);
        return game;
    }
}
