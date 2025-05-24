package org.example.scheduler.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.user.dto.SingUpRequestDto;
import org.example.scheduler.user.dto.SignUpResponseDto;
import org.example.scheduler.user.dto.LoginRequestDto;
import org.example.scheduler.user.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/singUp")
    public ResponseEntity<SignUpResponseDto> singUp(@RequestBody @Valid SingUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = authService.saveUser(requestDto);

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<String> login(
            @Valid @ModelAttribute LoginRequestDto requestDto,
            HttpServletRequest request
    ) {
        authService.login(requestDto, request);
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }
}

