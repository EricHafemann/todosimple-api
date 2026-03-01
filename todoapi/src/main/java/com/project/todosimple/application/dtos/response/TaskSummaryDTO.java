package com.project.todosimple.application.dtos.response;

import com.project.todosimple.domain.entities.Task;

public class TaskSummaryDTO {

    private Long id;
    private String description;

    // Construtores
    public TaskSummaryDTO() {}

    public TaskSummaryDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
    }

    public TaskSummaryDTO(Long id, String description) {
        this.id = id;
        this.description = description;
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
}