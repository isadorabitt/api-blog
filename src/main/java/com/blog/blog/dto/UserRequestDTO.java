package com.blog.blog.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = " Nome não pode ser  vazio.") @Min(2)
        String name,
        @NotBlank(message = "Email não pode ser vazio.") @Email
        String email,
        @NotBlank(message = "Senha não pode ser vazia.") @Min(8) @Max(12)
        String password
) {

}


