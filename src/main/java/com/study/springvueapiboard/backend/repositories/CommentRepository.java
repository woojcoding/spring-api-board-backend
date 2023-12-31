package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.CommentRequestDto;
import com.study.springvueapiboard.backend.dtos.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Comment repository.
 */
@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final CommentMapper commentMapper;

    /**
     * 댓글 목록을 반환해주는 메서드
     *
     * @param boardId 게시글 Id
     * @return List<CommentResponseDto>  댓글 List
     */
    public List<CommentResponseDto> getCommentList(int boardId) {
        return commentMapper.getCommentList(boardId);
    }

    /**
     * 댓글을 저장하는 메서드
     *
     * @param boardId           게시글 Id
     * @param commentRequestDto 게시글 본문을 담은 Dto
     */
    public void postComment(int boardId, CommentRequestDto commentRequestDto) {
        commentMapper.postComment(boardId, commentRequestDto);
    }
}
