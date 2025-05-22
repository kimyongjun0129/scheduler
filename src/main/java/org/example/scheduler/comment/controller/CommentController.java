package org.example.scheduler.comment.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.comment.dto.CreateCommentRequestDto;
import org.example.scheduler.comment.dto.CreateCommentResponseDto;
import org.example.scheduler.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> createComment(@RequestBody CreateCommentRequestDto requestDto) {
        CreateCommentResponseDto createCommentResponseDto = commentService.saveComment(requestDto);
        return new ResponseEntity<>(createCommentResponseDto, HttpStatus.CREATED);
    }
}
