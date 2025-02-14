package com.blog.blog.dto;

import com.blog.blog.model.User;

public record UserResponseDTO(String name, String email) {

    public UserResponseDTO(User user) {
        this(user.getName(), user.getEmail());
    }
}
