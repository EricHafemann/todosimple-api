package com.project.todosimple.application.dtos.request;

import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @Size(min = 2, max = 100, message = "Username deve ter entre 2 e 100 caracteres")
    private String username;

    @Size(min = 8, max = 60, message = "A senha deve ter entre 8 e 60 caracteres")
    private String password;

    // Construtores
    public UserUpdateDTO() {}

    public UserUpdateDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}