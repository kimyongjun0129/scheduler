package org.example.scheduler.schedule.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateScheduleRequestDto {
    @NotNull
    @Size(max = 10)
    private String password;

    @Size(min = 5)
    @NotNull
    private String title;

    @Max(100)
    @NotNull
    private String content;
}
