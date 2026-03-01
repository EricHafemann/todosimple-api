package com.project.todosimple.application.services;

import com.project.todosimple.domain.exceptions.TaskNotFoundException;
import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(
                        String.format("Tarefa não encontrada. Id: %d, Tipo: %s",
                                id, Task.class.getSimpleName())));
    }

    public List<Task> findAllByUserId(Long userId) {
        // Verifica se o usuário existe primeiro
        userService.findById(userId);
        return taskRepository.findByUser_Id(userId);
    }

    @Transactional
    public Task create(Task obj) {
        User user = userService.findById(obj.getUser().getId());
        obj.setId(null);
        obj.setUser(user);
        return taskRepository.save(obj);
    }

    @Transactional
    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return taskRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        Task task = findById(id);
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}