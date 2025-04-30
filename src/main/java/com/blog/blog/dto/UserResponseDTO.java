package com.blog.blog.dto;

import com.blog.blog.model.User;

public record UserResponseDTO(Long id, String name, String email) {

    public UserResponseDTO(User user) {
        this(user.getId(),user.getName(), user.getEmail());
    }
}
