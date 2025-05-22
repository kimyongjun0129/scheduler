package org.example.scheduler.comment.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.comment.dto.*;
import org.example.scheduler.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<FindCommentResponseDto> findCommentById(@PathVariable Long id, HttpServletRequest request) {
        FindCommentResponseDto findCommentResponseDto = commentService.findCommentById(id, request);

        return new ResponseEntity<>(findCommentResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateCommentResponseDto> updateComment(
            @PathVariable Long id,
            @RequestBody UpdateCommentRequestDto requestDto,
            HttpServletRequest request
    ) {
        UpdateCommentResponseDto updateCommentResponseDto = commentService.updateComment(id, requestDto, request);

        return new ResponseEntity<>(updateCommentResponseDto, HttpStatus.OK);
    }
}
