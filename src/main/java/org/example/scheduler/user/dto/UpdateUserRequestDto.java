package org.example.scheduler.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserRequestDto {
    @NotNull
    private final String username;
    @Email(message = "잘못된 이메일 형식입니다.")
    private final String email;
}
