package org.example.scheduler.comment.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.example.scheduler.comment.dto.*;
import org.example.scheduler.comment.entity.Comment;
import org.example.scheduler.comment.repository.CommentRepository;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Transactional
    public FindCommentResponseDto findCommentById(Long id, HttpServletRequest request) {
        Comment comment = getAuthorizedComment(id, request);

        return new FindCommentResponseDto(comment);
    }

    @Transactional
    public UpdateCommentResponseDto updateComment (Long id, UpdateCommentRequestDto requestDto, HttpServletRequest request) {
        Comment comment = getAuthorizedComment(id, request);

        comment.updateContent(requestDto.getContent());

        Comment savedComment = commentRepository.save(comment);

        return new UpdateCommentResponseDto(savedComment);
    }

    @Transactional
    public void deleteComment (Long id, HttpServletRequest request) {
        Comment comment = getAuthorizedComment(id, request);

        commentRepository.delete(comment);
    }

    private Comment getAuthorizedComment(Long id, HttpServletRequest request) {
        Comment comment = commentRepository.findByIdOrElseThrow(id);
        Long userId = comment.getUser().getId();

        HttpSession session = request.getSession();

        Long logInUserId = (Long) session.getAttribute("login-userId");

        if(!userId.equals(logInUserId)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This user is incorrect.");

        return comment;
    }
}
