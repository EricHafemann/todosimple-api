package com.project.todosimple.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskCreateDTO {

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String description;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long userId;

    // Construtores
    public TaskCreateDTO() {}

    public TaskCreateDTO(String description, Long userId) {
        this.description = description;
        this.userId = userId;
    }

    // Getters e Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}