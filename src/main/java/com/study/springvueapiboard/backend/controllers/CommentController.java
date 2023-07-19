package com.study.springvueapiboard.backend.controllers;

import com.study.springvueapiboard.backend.dtos.CommentRequestDto;
import com.study.springvueapiboard.backend.repositories.BoardSearchCondition;
import com.study.springvueapiboard.backend.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards/free/view/{boardId}")
@CrossOrigin(origins = "http://loacalhost:3000")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(
            @PathVariable("boardId") int boardId,
            @ModelAttribute("boardSearch")
            BoardSearchCondition boardSearchCondition,
            @RequestBody CommentRequestDto commentRequestDto
    ) {
        // 댓글을 post
        commentService.postComment(boardId, commentRequestDto);
    }
}
