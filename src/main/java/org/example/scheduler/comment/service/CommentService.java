package org.example.scheduler.comment.service;

import lombok.AllArgsConstructor;
import org.example.scheduler.comment.dto.CreateCommentRequestDto;
import org.example.scheduler.comment.dto.CreateCommentResponseDto;
import org.example.scheduler.comment.entity.Comment;
import org.example.scheduler.comment.repository.CommentRepository;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public CreateCommentResponseDto saveComment(CreateCommentRequestDto requestDto) {
        Long userId = requestDto.getUserId();
        User user = userRepository.findByIdOrElseThrow(userId);

        Long scheduleId = requestDto.getScheduleId();
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        Comment comment = new Comment(requestDto.getContent(), user, schedule);

        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponseDto(savedComment);
    }
}
