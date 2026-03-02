package com.project.todosimple.application.dtos.response;

import com.project.todosimple.domain.entities.Task;

public class TaskResponseDTO {

    private Long id;
    private String description;
    private UserSummaryDTO user;

    // Construtores
    public TaskResponseDTO() {}

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();

        if (task.getUser() != null) {
            this.user = new UserSummaryDTO(
                    task.getUser().getId(),
                    task.getUser().getUsername()
            );
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserSummaryDTO getUser() {
        return user;
    }

    public void setUser(UserSummaryDTO user) {
        this.user = user;
    }
}