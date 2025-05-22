package org.example.scheduler.user.controller;

import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<FindUserResponseDto> findUser(
            @PathVariable Long id,
            HttpServletRequest request
    ) {
        FindUserResponseDto userResponseDto = userService.findUserById(id, request);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto requestDto,
            HttpServletRequest request
    ) {
        UpdateUserResponseDto updateUserResponseDto = userService.updateUser(id, requestDto, request);

        return new ResponseEntity<>(updateUserResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id,
            @RequestBody DeleteUserRequestDto requestDto,
            HttpServletRequest request
    ) {
        userService.deleteUser(id, requestDto, request);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
