package org.example.scheduler.comment.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.scheduler.comment.dto.CreateCommentRequestDto;
import org.example.scheduler.comment.dto.CreateCommentResponseDto;
import org.example.scheduler.comment.dto.FindCommentResponseDto;
import org.example.scheduler.comment.entity.Comment;
import org.example.scheduler.comment.repository.CommentRepository;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public FindCommentResponseDto findCommentById(Long id, HttpServletRequest request) {
        Comment comment = commentRepository.findByIdOrElseThrow(id);
        Long userId = comment.getUser().getId();

        HttpSession session = request.getSession();

        Long logInUserId = (Long) session.getAttribute("login-userId");

        if(!userId.equals(logInUserId)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This user is incorrect.");

        return new FindCommentResponseDto(comment);
    }
}
