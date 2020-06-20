package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT question FROM Question question WHERE question.category.id = :catId")
    public List<Question> getQuestionsForCategory(@Param("catId") Integer categoryId);

    @Query("SELECT category FROM Category category WHERE category.game.id = :gameId")
    public List<Category> findCategoriesForGame(@Param("gameId") Integer gameId);
}
