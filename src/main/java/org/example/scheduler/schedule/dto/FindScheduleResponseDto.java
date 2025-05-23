package org.example.scheduler.schedule.dto;

import lombok.Getter;
import org.example.scheduler.schedule.entity.Schedule;

import java.util.Date;

@Getter
public class FindScheduleResponseDto {
    private final Long id;
    private final String title;
    private final Long userId;
    private final String content;
    private final Date updatedAt;

    public FindScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.userId = schedule.getUser().getId();
        this.content = schedule.getContent();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
