package org.example.scheduler.user.controller;

import jakarta.validation.Valid;
import org.example.scheduler.user.dto.CreateUserRequestDto;
import org.example.scheduler.user.dto.CreateUserResponseDto;
import org.example.scheduler.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody @Valid CreateUserRequestDto requestDto) {

        CreateUserResponseDto createUserResponseDto = userService.saveUser(requestDto);

        return new ResponseEntity<>(createUserResponseDto, HttpStatus.CREATED);
    }
}
