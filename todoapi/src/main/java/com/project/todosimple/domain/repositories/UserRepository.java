package com.project.todosimple.domain.repositories;

import com.project.todosimple.domain.entities.User;

import java.util.Optional;

public interface UserRepository{

    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
