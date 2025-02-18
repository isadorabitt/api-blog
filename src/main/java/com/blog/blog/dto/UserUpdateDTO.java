package com.blog.blog.dto;

import com.blog.blog.model.User;

public record UserUpdateDTO(String name, String email) {
    public UserUpdateDTO(User user) {
        this(user.getName(), user.getEmail());
    }

}
