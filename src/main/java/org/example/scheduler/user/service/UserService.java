package org.example.scheduler.user.service;

import org.example.scheduler.user.dto.CreateUserRequestDto;
import org.example.scheduler.user.dto.CreateUserResponseDto;

public interface UserService {
    CreateUserResponseDto saveUser(CreateUserRequestDto requestDto);
}
