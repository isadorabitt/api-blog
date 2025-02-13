package com.blog.blog.controller;


import com.blog.blog.model.User;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String olaMundo() {
        return "Olá mundo";
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
       return userService.save(user);
    }
}
