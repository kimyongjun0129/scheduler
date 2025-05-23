package org.example.scheduler.comment.dto;

import lombok.Getter;
import org.example.scheduler.comment.entity.Comment;

import java.util.Date;

@Getter
public class CreateCommentResponseDto {
    private final Long id;
    private final String content;
    private final Long userId;
    private final Long scheduleId;
    private final Date createdAt;

    public CreateCommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUser().getId();
        this.scheduleId = comment.getSchedule().getId();
        this.createdAt = comment.getCreatedAt();
    }
}
