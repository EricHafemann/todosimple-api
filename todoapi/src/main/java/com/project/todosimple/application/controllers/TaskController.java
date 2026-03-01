package com.project.todosimple.application.controllers;

import com.project.todosimple.application.dtos.request.TaskCreateDTO;
import com.project.todosimple.application.dtos.response.TaskResponseDTO;
import com.project.todosimple.application.dtos.response.TaskSummaryDTO;
import com.project.todosimple.application.services.TaskApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskApplicationService taskApplicationService;

    public TaskController(TaskApplicationService taskApplicationService) {
        this.taskApplicationService = taskApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskApplicationService.findById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskSummaryDTO>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(taskApplicationService.findAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@Valid @RequestBody TaskCreateDTO dto) {
        TaskResponseDTO createdTask = taskApplicationService.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTask.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}