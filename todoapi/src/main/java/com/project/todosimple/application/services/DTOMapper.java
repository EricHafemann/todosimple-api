package com.project.todosimple.application.services;

import com.project.todosimple.application.dtos.request.TaskCreateDTO;
import com.project.todosimple.application.dtos.request.TaskUpdateDTO;
import com.project.todosimple.application.dtos.request.UserCreateDTO;
import com.project.todosimple.application.dtos.request.UserUpdateDTO;
import com.project.todosimple.application.dtos.response.TaskResponseDTO;
import com.project.todosimple.application.dtos.response.TaskSummaryDTO;
import com.project.todosimple.application.dtos.response.UserResponseDTO;
import com.project.todosimple.application.dtos.response.UserSummaryDTO;
import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {


    public Task toEntity(TaskCreateDTO dto) {
        if (dto == null) return null;

        Task task = new Task();
        task.setDescription(dto.getDescription());
        return task;
    }

    public User toEntity(UserCreateDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }


    public void updateEntity(Task task, TaskUpdateDTO dto) {
        if (dto == null || task == null) return;

        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
    }

    public void updateEntity(User user, UserUpdateDTO dto) {
        if (dto == null || user == null) return;

        if (dto.getUsername() != null) {
            user.setUsername(dto.getUsername());
        }
        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword());
        }
    }

    public TaskResponseDTO toResponseDTO(Task task) {
        if (task == null) return null;

        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());

        if (task.getUser() != null) {
            dto.setUser(toSummaryDTO(task.getUser()));
        }

        return dto;
    }

    public TaskSummaryDTO toSummaryDTO(Task task) {
        if (task == null) return null;

        TaskSummaryDTO dto = new TaskSummaryDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());

        return dto;
    }

    public UserResponseDTO toResponseDTO(User user) {
        if (user == null) return null;

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }

    public UserSummaryDTO toSummaryDTO(User user) {
        if (user == null) return null;

        UserSummaryDTO dto = new UserSummaryDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }
}