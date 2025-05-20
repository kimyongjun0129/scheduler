package org.example.scheduler.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateScheduleRequestDto {
    private String username;
    private String title;
    private String content;
    private String password;
}
