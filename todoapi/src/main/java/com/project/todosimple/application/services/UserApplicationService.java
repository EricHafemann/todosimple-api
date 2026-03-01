package com.project.todosimple.application.services;

import com.project.todosimple.application.dtos.request.UserCreateDTO;
import com.project.todosimple.application.dtos.request.UserUpdateDTO;
import com.project.todosimple.application.dtos.response.UserResponseDTO;
import com.project.todosimple.domain.entities.User;
import com.project.todosimple.domain.exceptions.UserNotFoundException;
import com.project.todosimple.domain.repositories.UserRepository;
import com.project.todosimple.domain.services.UserDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserApplicationService {

    private final UserDomainService userDomainService;
    private final UserRepository userRepository;
    private final DTOMapper mapper;

    public UserApplicationService(
            UserDomainService userDomainService,
            UserRepository userRepository,
            DTOMapper mapper) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {  // ✅ NOME CORRETO!
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + id));
        return mapper.toResponseDTO(user);
    }

    @Transactional
    public UserResponseDTO create(UserCreateDTO dto) {  // ✅ NOME CORRETO!
        userDomainService.validateUserCreation(dto.getUsername(), dto.getPassword());

        String encryptedPassword = userDomainService.encryptPassword(dto.getPassword());

        User user = new User(dto.getUsername(), encryptedPassword);

        User savedUser = userRepository.save(user);

        return mapper.toResponseDTO(savedUser);
    }

    @Transactional
    public UserResponseDTO update(Long id, UserUpdateDTO dto) {  // ✅ NOME CORRETO!
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado: " + id));

        userDomainService.validateUserUpdate(existingUser, dto.getUsername(), dto.getPassword());

        if (dto.getUsername() != null) {
            existingUser.setUsername(dto.getUsername());
        }

        if (dto.getPassword() != null) {
            String encryptedPassword = userDomainService.encryptPassword(dto.getPassword());
            existingUser.setPassword(encryptedPassword);
        }

        User updatedUser = userRepository.save(existingUser);

        return mapper.toResponseDTO(updatedUser);
    }

    @Transactional
    public void delete(Long id) {  // ✅ NOME CORRETO!
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Usuário não encontrado: " + id);
        }
        userRepository.deleteById(id);
    }
}