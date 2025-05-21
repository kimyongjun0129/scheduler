package org.example.scheduler.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserRequestDto {
    @NotNull
    private final String username;
    @Email(message = "이메일 형식이 올바르지 않습니다")
    private final String email;
    @NotNull
    private final String password;
}
