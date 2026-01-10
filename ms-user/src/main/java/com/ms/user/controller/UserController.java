package com.ms.user.controller;

import com.ms.user.dto.UserRequestDTO;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.model.User;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        UserResponseDTO userResponse = userService.saveUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
