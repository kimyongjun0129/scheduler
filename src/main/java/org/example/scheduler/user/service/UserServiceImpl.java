package org.example.scheduler.user.service;

import org.example.scheduler.user.dto.*;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponseDto saveUser(CreateUserRequestDto requestDto) {

        User user = new User(requestDto.getUsername(), requestDto.getEmail());
        User savedUser = userRepository.save(user);

        return new CreateUserResponseDto(savedUser);
    }

    @Override
    public FindUserResponseDto findUserById(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);

        return new FindUserResponseDto(user);
    }

    @Override
    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto requestDto) {
        User user = userRepository.findByIdOrElseThrow(id);

        if (requestDto.getUsername() != null) {
            user.updateUsername(requestDto.getUsername());
        }

        if (requestDto.getEmail() != null) {
            user.updateEmail(requestDto.getEmail());
        }

        return new UpdateUserResponseDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(user);
    }
}
