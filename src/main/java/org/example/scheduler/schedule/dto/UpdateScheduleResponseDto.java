package org.example.scheduler.schedule.dto;

import lombok.Getter;
import org.example.scheduler.schedule.entity.Schedule;

import java.util.Date;

@Getter
public class UpdateScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Date updateAt;

    public UpdateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.updateAt = schedule.getUpdatedAt();
    }
}
