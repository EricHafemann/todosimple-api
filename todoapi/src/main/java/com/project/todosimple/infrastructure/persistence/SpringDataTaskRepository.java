package com.project.todosimple.infrastructure.persistence;

import com.project.todosimple.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser_Id(Long userId);
}