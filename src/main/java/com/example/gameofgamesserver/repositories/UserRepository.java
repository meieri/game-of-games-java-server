package com.example.gameofgamesserver.repositories;

import com.example.gameofgamesserver.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
