package org.example.scheduler.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.scheduler.user.dto.*;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponseDto saveUser(CreateUserRequestDto requestDto) {

        User user = new User(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        User savedUser = userRepository.save(user);

        return new CreateUserResponseDto(savedUser);
    }

    @Override
    public FindUserResponseDto findUserById(Long id, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to find this user.");
        }

        return new FindUserResponseDto(user);
    }

    @Override
    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto requestDto, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to update this user.");
        }

        User savedUser = userRepository.save(user);

        return new UpdateUserResponseDto(savedUser);
    }

    @Override
    public void deleteUser(Long id, DeleteUserRequestDto requestDto, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to delete this user.");
        }

        if(!user.getPassword().equals(requestDto.getPassword())) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This password is incorrect.");

        userRepository.delete(user);
    }
}
