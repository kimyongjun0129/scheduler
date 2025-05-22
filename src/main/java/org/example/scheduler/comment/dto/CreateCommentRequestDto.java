package org.example.scheduler.comment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCommentRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long scheduleId;

    @NotNull
    private String content;
}
