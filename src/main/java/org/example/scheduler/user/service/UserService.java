package org.example.scheduler.user.service;

import org.example.scheduler.user.dto.CreateUserRequestDto;
import org.example.scheduler.user.dto.CreateUserResponseDto;
import org.example.scheduler.user.dto.FindUserResponseDto;

public interface UserService {
    CreateUserResponseDto saveUser(CreateUserRequestDto requestDto);
    FindUserResponseDto findUserById(Long id);

}
