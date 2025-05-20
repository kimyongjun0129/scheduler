package org.example.scheduler.schedule.dto;

import lombok.Getter;
import org.example.scheduler.schedule.entity.Schedule;

import java.util.Date;

@Getter
public class CreateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final Long userId;
    private final String content;
    private final Date createdAt;
    private final Date updatedAt;

    public CreateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.userId = schedule.getUserId();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
