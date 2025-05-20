package org.example.scheduler.schedule.dto;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {
    @Column(nullable = false)
    private String password;
}
