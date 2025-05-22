package org.example.scheduler.schedule.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {
    @NotNull
    private Long userId;

    @Size(min = 5)
    @NotNull
    private String title;

    @Size(max = 100)
    @NotNull
    private String content;

    @NotNull
    @Min(10)
    private String password;
}
