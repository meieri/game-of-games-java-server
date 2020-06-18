package com.example.gameofgamesserver.services;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Question;
import com.example.gameofgamesserver.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository repository;

    public Question createQuestion(Question question, Category category) {
        question.setCategory(category);
        return repository.save(question);
    }
}
