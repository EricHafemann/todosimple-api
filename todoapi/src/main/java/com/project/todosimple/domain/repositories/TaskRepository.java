package com.project.todosimple.domain.repositories;

import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
    List<Task> findAll();
    boolean existsById(Long id);
    void delete(Task task);
    List<Task> findByUser(User user);
    long countByUser(User user);

}