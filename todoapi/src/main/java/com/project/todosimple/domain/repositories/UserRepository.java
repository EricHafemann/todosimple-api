package com.project.todosimple.domain.repositories;

import com.project.todosimple.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    boolean existsById(Long id);

    List<User> findAll();

    void delete(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findAllWithTaskCount();
}