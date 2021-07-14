package com.example.apirestdisney.controllers;

import com.example.apirestdisney.entities.UserEntity;
import com.example.apirestdisney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register", consumes = "application/json")
    public String register(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        String token = userService.crearToken(userEntity);
        return token;
    }

    @PostMapping(path = "login", consumes = "application/json")
    public String login(@RequestParam String mail, @RequestParam String token){
        return userService.login(mail, token);
    }
}
