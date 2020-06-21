package com.example.gameofgamesserver.controllers;

import com.example.gameofgamesserver.models.User;
import com.example.gameofgamesserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("api/user/name")
    public User updateUsername(@RequestBody String username, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        currentUser.setUsername(username);
        // might actually create new user & not just update
        return service.createUser(currentUser);
    }

    @PostMapping("api/user/pass")
    public User updatePassword(@RequestBody String password, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        currentUser.setPassword(password);
        // might actually create new user & not just update
        return service.createUser(currentUser);
    }

    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpSession session) {
        User currentUser = service.createUser(user);
        session.setAttribute("currentUser", currentUser);
        return currentUser;
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpSession session) {
        User currUser = service.findUserByCredentials(user.getUsername(), user.getPassword());
        if (currUser == null) {
            User badLogin = new User();
            badLogin.setUsername("BADLOGIN");
            return badLogin;
        }
        session.setAttribute("currentUser", currUser);
        return currUser;
    }

    @PostMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
