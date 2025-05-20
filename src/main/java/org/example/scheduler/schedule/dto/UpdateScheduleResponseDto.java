package org.example.scheduler.schedule.dto;

import lombok.Getter;
import org.example.scheduler.schedule.entity.Schedule;

@Getter
public class UpdateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String content;

    public UpdateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
    }
}
