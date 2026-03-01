package com.project.todosimple.services;

import com.project.todosimple.models.User;
import com.project.todosimple.repositories.TaskRepository;
import com.project.todosimple.exceptions.*;
import com.project.todosimple.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
                ));
    }

    @Transactional
    public User create(User user)
    {
        user.setId(null);
        user = this.userRepository.save(user);
        return user;
    }

    public User update (User user)
    {
        User newUser = findById(user.getId());
        newUser.setPassword(user.getPassword());
        return this.userRepository.save(newUser);
    }

    public void delete (Long id)
    {
        findById(id);
        try
        {
            this.userRepository.deleteById(id);
        }catch (Exception e)
        {
            throw new RuntimeException("Não é possivel excluir pois há entidades relacionadas!");
        }
    }
}
