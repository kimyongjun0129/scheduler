package org.example.scheduler.user.dto;

import lombok.Getter;
import org.example.scheduler.user.entity.User;

@Getter
public class UpdateUserResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    public UpdateUserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getUsername();
        this.email = user.getEmail();
    }
}
