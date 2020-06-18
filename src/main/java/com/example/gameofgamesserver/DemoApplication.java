package com.example.gameofgamesserver;

import com.example.gameofgamesserver.models.Category;
import com.example.gameofgamesserver.models.Game;
import com.example.gameofgamesserver.models.Question;
import com.example.gameofgamesserver.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(DemoApplication.class, args);

		// User user = new User();
		// Game game = new Game();
		// Category cat = new Category();

		// List<Question> qs = new ArrayList<Question>();
		// Question q = new Question();
		// qs.add(q);
		// Question q1 = new Question();
		// qs.add(q1);
		// Question q3 = new Question();
		// qs.add(q3);
		// cat.setQuestions(qs);
		// List<Category> cats = new ArrayList<Category>();
		// cats.add(cat);
		// game.setCategories(cats);

		// ObjectMapper objectMapper = new ObjectMapper();
		// final String json = objectMapper.writeValueAsString(game);
		// System.out.println(json);
	}

}
