package org.example.scheduler.schedule.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {
    @NotNull
    private Long userId;
    private String title;
    private String content;
    @NotNull
    private String password;
}
