package com.blog.blog.controller;


import com.blog.blog.dto.UserRequestDTO;
import com.blog.blog.dto.UserResponseDTO;
import com.blog.blog.model.User;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO userResponseDTO = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User findByUser(@PathVariable Long id){
        return userService.findByUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user ){
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
         userService.deleteUser(id);
    }

}
