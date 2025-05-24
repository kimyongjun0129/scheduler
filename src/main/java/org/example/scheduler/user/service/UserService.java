package org.example.scheduler.user.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.scheduler.user.dto.*;

public interface UserService {
    FindUserResponseDto findUserById(Long id, HttpServletRequest request);
    UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto requestDto, HttpServletRequest request);
    void deleteUser (Long id, DeleteUserRequestDto requestDto, HttpServletRequest request);
}
