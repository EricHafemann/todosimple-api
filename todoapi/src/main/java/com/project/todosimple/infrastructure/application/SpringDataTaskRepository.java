package com.project.todosimple.infrastructure.application;

import com.project.todosimple.domain.entities.Task;
import com.project.todosimple.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    long countByUser(User user);

}