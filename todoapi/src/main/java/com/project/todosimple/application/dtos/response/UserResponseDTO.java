package com.project.todosimple.application.dtos.response;

import com.project.todosimple.domain.entities.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDTO {

    private Long id;
    private String username;
    private List<TaskSummaryDTO> tasks;

    // Construtores
    public UserResponseDTO() {}

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();

        if (user.getTasks() != null) {
            this.tasks = user.getTasks().stream()
                    .map(TaskSummaryDTO::new)
                    .collect(Collectors.toList());
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TaskSummaryDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskSummaryDTO> tasks) {
        this.tasks = tasks;
    }
}