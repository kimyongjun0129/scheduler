package org.example.scheduler.user.dto;

import lombok.Getter;
import org.example.scheduler.user.entity.User;

import java.util.Date;

@Getter
public class CreateUserResponseDto {
    private final Long id;
    private final String username;
    private final String email;
    private final Date createdAt;
    private final Date updatedAt;

    public CreateUserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
