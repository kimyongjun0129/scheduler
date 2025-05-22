package org.example.scheduler.login.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.PasswordEncoder;
import org.example.scheduler.login.dto.LoginRequestDto;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
