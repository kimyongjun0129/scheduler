package org.example.scheduler.user.dto;

import lombok.Getter;
import org.example.scheduler.user.entity.User;

@Getter
public class FindUserResponseDto {
    private final Long id;
    private final String username;
    private final String email;

    public FindUserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
