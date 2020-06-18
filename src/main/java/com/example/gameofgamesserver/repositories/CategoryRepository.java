package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
