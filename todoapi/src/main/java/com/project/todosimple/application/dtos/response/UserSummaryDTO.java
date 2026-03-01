package com.project.todosimple.application.dtos.response;

public class UserSummaryDTO {

    private Long id;
    private String username;

    // Construtores
    public UserSummaryDTO() {}

    public UserSummaryDTO(Long id, String username) {
        this.id = id;
        this.username = username;
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
}