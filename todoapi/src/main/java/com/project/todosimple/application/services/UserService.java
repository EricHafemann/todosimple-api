package com.project.todosimple.application.services;

import com.project.todosimple.domain.exceptions.UserNotFoundException;
import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Usuário não encontrado! Id: %d, Tipo: %s",
                                id, User.class.getSimpleName())
                ));
    }

    @Transactional
    public User create(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Transactional
    public User update(User user) {
        User newUser = findById(user.getId());
        newUser.setPassword(user.getPassword());
        newUser.setUsername(user.getUsername());
        return userRepository.save(newUser);
    }

    @Transactional
    public void delete(Long id) {
        findById(id); // Verifica se existe
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir usuário pois há tarefas relacionadas!");
        }
    }
}