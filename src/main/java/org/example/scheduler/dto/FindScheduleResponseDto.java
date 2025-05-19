package org.example.scheduler.dto;

import lombok.Getter;
import org.example.scheduler.entity.Schedule;

import java.util.Date;

@Getter
public class FindScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String username;
    private final String content;
    private final Date createdAt;
    private final Date updatedAt;

    public FindScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.username = schedule.getUsername();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
