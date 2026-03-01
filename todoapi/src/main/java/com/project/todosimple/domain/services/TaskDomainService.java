package com.project.todosimple.domain.services;

import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.exceptions.DomainException;
import com.project.todosimple.domain.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskDomainService {

    private final TaskRepository taskRepository;

    public TaskDomainService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void validateTaskCreation(String description, User user) {

        // Validação de descrição
        if (description == null || description.trim().length() < 3) {
            throw new DomainException("Descrição deve ter pelo menos 3 caracteres");
        }
        if (description.length() > 255) { // Ajustado para 255 (tamanho da sua coluna)
            throw new DomainException("Descrição não pode ter mais que 255 caracteres");
        }

        // Limite de tarefas por usuário
        long taskCount = taskRepository.countByUser(user);
        if (taskCount >= 20) {
            throw new DomainException("Usuário atingiu limite máximo de 20 tarefas");
        }
    }
}