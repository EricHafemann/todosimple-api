package com.project.todosimple.infrastructure.persistence;

import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.repositories.TaskRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SpringDataTaskRepository springDataRepository;

    public TaskRepositoryImpl(SpringDataTaskRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return springDataRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public List<Task> findByUser_Id(Long userId) {
        return springDataRepository.findByUser_Id(userId);
    }
}