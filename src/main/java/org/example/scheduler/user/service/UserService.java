package org.example.scheduler.user.service;

import org.example.scheduler.user.dto.*;

public interface UserService {
    CreateUserResponseDto saveUser(CreateUserRequestDto requestDto);
    FindUserResponseDto findUserById(Long id);
    UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto requestDto);
    void deleteUser (Long id, DeleteUserRequestDto requestDto);
}
