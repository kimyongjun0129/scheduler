package org.example.scheduler.login.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.login.dto.LoginRequestDto;
import org.example.scheduler.login.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    ResponseEntity<String> login(
            @Valid @ModelAttribute LoginRequestDto requestDto,
            HttpServletRequest request
    ) {
        loginService.login(requestDto, request);
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }
}

