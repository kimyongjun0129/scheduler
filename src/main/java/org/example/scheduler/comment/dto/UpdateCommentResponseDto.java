package org.example.scheduler.comment.dto;

import lombok.Getter;
import org.example.scheduler.comment.entity.Comment;

import java.util.Date;

@Getter
public class UpdateCommentResponseDto {
    private final Long id;
    private final Long userId;
    private final Long scheduleId;
    private final String content;
    private final Date updateAt;

    public UpdateCommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.scheduleId = comment.getSchedule().getId();
        this.content = comment.getContent();
        this.updateAt = comment.getUpdatedAt();
    }
}
