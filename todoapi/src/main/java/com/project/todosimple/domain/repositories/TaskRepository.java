package com.project.todosimple.domain.repositories;

import com.project.todosimple.domain.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository
{

    List<Task> findByUser_Id(Long userId);
    Optional<Task> findById(Long id);
    Task save(Task task);
    void deleteById(Long id);
    List<Task> findAll();
}
