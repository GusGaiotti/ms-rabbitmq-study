package com.ms.user.service;

import com.ms.user.dto.UserRequestDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.model.User;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO.name(), userRequestDTO.email());
        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getUserId(), savedUser.getName(), savedUser.getEmail());
    }
}
