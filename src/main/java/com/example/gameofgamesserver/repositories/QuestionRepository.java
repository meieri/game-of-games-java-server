package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
