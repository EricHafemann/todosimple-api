package com.project.todosimple.domain.services;

import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.exceptions.DomainException;
import com.project.todosimple.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUserCreation(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new DomainException("Username é obrigatório");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new DomainException("Senha é obrigatória");
        }
        if (userRepository.existsByUsername(username)) {
            throw new DomainException("Username já está em uso");
        }
    }

    public String encryptPassword(String rawPassword) {
        return rawPassword;
    }

    public void validateUserUpdate(User existingUser, String newUsername, String newPassword) {
        if (newUsername != null && !newUsername.equals(existingUser.getUsername())) {
            if (userRepository.existsByUsername(newUsername)) {
                throw new DomainException("Username já está em uso");
            }
        }
    }
}