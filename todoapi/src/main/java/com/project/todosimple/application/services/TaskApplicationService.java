package com.project.todosimple.application.services;

import com.project.todosimple.application.dtos.request.TaskCreateDTO;
import com.project.todosimple.application.dtos.response.TaskResponseDTO;
import com.project.todosimple.application.dtos.response.TaskSummaryDTO;
import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.exceptions.DomainException;
import com.project.todosimple.domain.exceptions.TaskNotFoundException;
import com.project.todosimple.domain.exceptions.UserNotFoundException;
import com.project.todosimple.domain.repositories.TaskRepository;
import com.project.todosimple.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskApplicationService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final DTOMapper mapper;

    public TaskApplicationService(
            TaskRepository taskRepository,
            UserRepository userRepository,
            DTOMapper mapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada: " + id));
        return mapper.toResponseDTO(task);
    }

    @Transactional(readOnly = true)
    public List<TaskSummaryDTO> findAllByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + userId));

        return taskRepository.findByUser(user).stream()
                .map(mapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskResponseDTO create(TaskCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + dto.getUserId()));

        if (dto.getDescription() == null || dto.getDescription().trim().isEmpty()) {
            throw new DomainException("Descrição é obrigatória");
        }

        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setUser(user);

        Task savedTask = taskRepository.save(task);

        return mapper.toResponseDTO(savedTask);
    }

    @Transactional
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Tarefa não encontrada: " + id);
        }
        taskRepository.deleteById(id);
    }
}