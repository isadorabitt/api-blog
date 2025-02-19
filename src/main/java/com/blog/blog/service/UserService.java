package com.blog.blog.service;

import com.blog.blog.dto.UserRequestDTO;
import com.blog.blog.dto.UserResponseDTO;
import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO save(UserRequestDTO request) {
        User user = User.builder().name(request.name()).email(request.email()).build();

        userRepository.save(user);
        return new UserResponseDTO(user);
    }

    public List<UserResponseDTO> getAll() {

        var usuarios = userRepository.findAll();
        return usuarios.stream().map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail())).toList();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public void updateUser(Long id, UserRequestDTO requestDTO) {
        var usuarioEncontrado = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
        usuarioEncontrado.setName(requestDTO.name());
        usuarioEncontrado.setEmail(requestDTO.email());
        userRepository.save(usuarioEncontrado);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}