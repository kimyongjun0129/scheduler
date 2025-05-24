package org.example.scheduler.user.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.common.security.PasswordEncoder;
import org.example.scheduler.user.dto.SingUpRequestDto;
import org.example.scheduler.user.dto.SignUpResponseDto;
import org.example.scheduler.user.dto.LoginRequestDto;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUpResponseDto saveUser(SingUpRequestDto requestDto) {
        // 비밀 번호 암호화
        String encodePassword = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(requestDto.getUsername(), requestDto.getEmail(), encodePassword);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser);
    }

    public void login(LoginRequestDto requestDto, HttpServletRequest request) {
        // 유저 이메일 검증
        User user = userRepository.findByEmailOrElseThrow(requestDto.getEmail());

        // 비밀 번호 검증
        boolean matches = passwordEncoder.matches(requestDto.getPassword(), user.getPassword());

        // 비밀 번호 검증 후 예외 발생
        if (!matches) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This password is incorrect.");
        }

        HttpSession session = request.getSession();

        session.setAttribute("login-userId", user.getId());
    }
}
