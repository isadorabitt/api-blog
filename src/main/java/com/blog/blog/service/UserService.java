package com.blog.blog.service;

import com.blog.blog.model.User;
import com.blog.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();

    }

    public User findByUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public User updateUser(Long id, User user) {
        var usuarioEncontrado = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));

        usuarioEncontrado.setName(user.getName());
        usuarioEncontrado.setEmail(user.getEmail());
        return userRepository.save(usuarioEncontrado);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}