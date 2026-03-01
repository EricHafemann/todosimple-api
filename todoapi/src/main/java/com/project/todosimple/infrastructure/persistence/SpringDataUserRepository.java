package com.project.todosimple.infrastructure.persistence;

import com.project.todosimple.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataUserRepository extends JpaRepository<User, Long> {

}