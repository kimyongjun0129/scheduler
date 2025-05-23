package org.example.scheduler.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.scheduler.comment.entity.Comment;

import java.util.Date;

@Getter
@AllArgsConstructor
public class FindCommentResponseDto {

    private final Long id;
    private final String content;
    private final Long userId;
    private final Long scheduleId;

    public FindCommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.scheduleId = comment.getSchedule().getId();
        this.content = comment.getContent();
    }
}
