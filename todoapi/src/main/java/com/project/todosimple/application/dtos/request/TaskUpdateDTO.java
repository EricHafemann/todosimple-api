package com.project.todosimple.application.dtos.request;

import jakarta.validation.constraints.Size;

public class TaskUpdateDTO {

    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String description;

    // Construtores
    public TaskUpdateDTO() {}

    public TaskUpdateDTO(String description) {
        this.description = description;
    }

    // Getters e Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}