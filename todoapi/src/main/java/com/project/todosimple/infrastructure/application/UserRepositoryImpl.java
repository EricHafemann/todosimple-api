package com.project.todosimple.infrastructure.application;

import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public boolean existsById(Long id) {
        return springDataRepository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return springDataRepository.findAll();
    }

    @Override
    public void delete(User user) {
        springDataRepository.delete(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return springDataRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return springDataRepository.existsByUsername(username);
    }

    @Override
    public List<User> findAllWithTaskCount() {
        List<Object[]> results = springDataRepository.findAllWithTaskCountRaw();

        return results.stream()
                .map(result -> {
                    User user = (User) result[0];
                    Long taskCount = (Long) result[1];
                    return user;
                })
                .collect(Collectors.toList());
    }
}