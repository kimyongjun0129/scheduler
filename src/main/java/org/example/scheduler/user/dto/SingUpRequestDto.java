package org.example.scheduler.user.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingUpRequestDto {
    @NotNull
    @Size(max = 100)
    private final String username;

    @NotNull
    @Email(message = "이메일 형식이 올바르지 않습니다")
    private final String email;

    @NotNull
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{10,}$",
            message = "비밀번호는 10자 이상이며, 대소문자, 숫자, 특수문자를 포함해야 합니다."
    )
    private final String password;
}
