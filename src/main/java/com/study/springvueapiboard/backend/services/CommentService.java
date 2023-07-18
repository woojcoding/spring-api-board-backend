package com.study.springvueapiboard.backend.services;

import com.study.springvueapiboard.backend.dtos.CommentResponseDto;
import com.study.springvueapiboard.backend.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Comment service.
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    /**
     * 게시글Id로 댓글들을 가져온ㄴ 메서드
     *
     * @param boardId 게시글 Id
     * @return 댓글 List
     */
    public List<CommentResponseDto> getCommentList(int boardId) {
        return commentRepository.getCommentList(boardId);
    }
}
