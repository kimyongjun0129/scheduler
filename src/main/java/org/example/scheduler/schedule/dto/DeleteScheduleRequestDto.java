package org.example.scheduler.schedule.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {
    @NotNull
    private String password;
}
