package org.example.scheduler.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.common.SessionType;
import org.example.scheduler.common.security.PasswordEncoder;
import org.example.scheduler.user.dto.*;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public FindUserResponseDto findUserById(Long id, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute(SessionType.USER);

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to find this user.");
        }

        return new FindUserResponseDto(user);
    }

    @Override
    @Transactional
    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto requestDto, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute(SessionType.USER);

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to update this user.");
        }

        User savedUser = userRepository.save(user);

        return new UpdateUserResponseDto(savedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id, DeleteUserRequestDto requestDto, HttpServletRequest request) {
        User user = userRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute(SessionType.USER);

        if(!user.getId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to delete this user.");
        }

        if(!user.getPassword().equals(requestDto.getPassword())) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This password is incorrect.");

        userRepository.delete(user);
    }
}
