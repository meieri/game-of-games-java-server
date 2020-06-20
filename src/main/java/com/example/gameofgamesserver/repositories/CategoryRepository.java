package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("SELECT category FROM Category category WHERE category.game.id = :gameId")
    public List<Category> findCategoriesForGame(@Param("gameId") Integer gameId);

}
