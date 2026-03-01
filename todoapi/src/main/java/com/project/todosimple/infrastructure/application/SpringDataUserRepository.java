package com.project.todosimple.infrastructure.application;

import com.project.todosimple.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends JpaRepository<User, Long> {

    // Métodos derivados do nome
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    // Query customizada para contar tarefas
    @Query("SELECT u, SIZE(u.tasks) as taskCount FROM User u")
    List<Object[]> findAllWithTaskCountRaw();

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.tasks")
    List<User> findAllWithTasks();
}