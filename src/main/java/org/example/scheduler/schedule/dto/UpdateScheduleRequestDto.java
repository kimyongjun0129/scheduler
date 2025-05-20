package org.example.scheduler.schedule.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateScheduleRequestDto {
    @Column(nullable = false)
    private String password;
    private String title;
    private String content;
}
