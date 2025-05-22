package org.example.scheduler.user.controller;

import jakarta.validation.Valid;
import org.example.scheduler.user.dto.*;
import org.example.scheduler.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<FindUserResponseDto> findUser(@PathVariable Long id) {
        FindUserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto requestDto
    ) {
        UpdateUserResponseDto updateUserResponseDto = userService.updateUser(id, requestDto);

        return new ResponseEntity<>(updateUserResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id,
            @RequestBody DeleteUserRequestDto requestDto
    ) {
        userService.deleteUser(id, requestDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
