package com.study.springvueapiboard.backend.controllers;

import com.study.springvueapiboard.backend.dtos.BoardDetailResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardListDto;
import com.study.springvueapiboard.backend.dtos.CategoryDto;
import com.study.springvueapiboard.backend.dtos.CommentResponseDto;
import com.study.springvueapiboard.backend.dtos.FileDto;
import com.study.springvueapiboard.backend.repositories.BoardSearchCondition;
import com.study.springvueapiboard.backend.services.BoardService;
import com.study.springvueapiboard.backend.services.CategoryService;
import com.study.springvueapiboard.backend.services.CommentService;
import com.study.springvueapiboard.backend.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private final BoardService boardService;

    private final CategoryService categoryService;

    private final CommentService commentService;

    private final FileService fileService;

    /**
     * 게시글 목록을 조회하는데 사용되는 메서드.
     *
     * @param boardSearchCondition 검색 조건
     * @return board
     */
    @GetMapping("/boards/free/list")
    public BoardListDto getBoards(@ModelAttribute BoardSearchCondition boardSearchCondition) {
        // 게시글 정보 조회
        BoardListDto boardListDto = boardService
                .getBoardList(boardSearchCondition);

        // 검색 기능에 필요한 카테고리
        List<CategoryDto> categoryDtoList = categoryService.getCategoryList();

        boardListDto.setCategoryDtoList(categoryDtoList);

        return boardListDto;
    }

    /**
     * 게시글에 대한 상세정보를 리턴해주는 메서드
     *
     * @param boardId              조회할 게시글 Id
     * @param boardSearchCondition 검색 조건
     * @return the board
     */
    @GetMapping("/boards/free/view/{boardId}")
    public BoardDetailResponseDto getBoard(
            @PathVariable("boardId") int boardId,
            @ModelAttribute("boardSearch")
            BoardSearchCondition boardSearchCondition
    ) {
        // 게시글 정보 조회
        boardService.updateViews(boardId);

        BoardDetailResponseDto boardDetailResponseDto =
                boardService.getBoard(boardId);

        // 댓글 정보 조회
        List<CommentResponseDto> commentList =
                commentService.getCommentList(boardId);

        boardDetailResponseDto.setCommentList(commentList);

        // 파일 정보 조회
        List<FileDto> fileDtoList = fileService.getFileList(boardId);

        boardDetailResponseDto.setFileDtoList(fileDtoList);

        return boardDetailResponseDto;
    }
}
