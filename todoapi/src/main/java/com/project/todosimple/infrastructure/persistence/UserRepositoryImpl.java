package com.project.todosimple.infrastructure.persistence;

import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository springDataRepository;

    public UserRepositoryImpl(SpringDataUserRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return springDataRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        springDataRepository.deleteById(id);
    }
}