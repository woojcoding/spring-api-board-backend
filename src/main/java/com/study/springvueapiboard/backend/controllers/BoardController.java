package com.study.springvueapiboard.backend.controllers;

import com.study.springvueapiboard.backend.dtos.BoardListDto;
import com.study.springvueapiboard.backend.dtos.CategoryDto;
import com.study.springvueapiboard.backend.repositories.BoardSearchCondition;
import com.study.springvueapiboard.backend.services.BoardService;
import com.study.springvueapiboard.backend.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 게시글 목록을 조회하는데 사용되는 메서드.
     *
     * @param boardSearchCondition 검색 조건
     * @return board
     */
    @GetMapping("/boards/free/list")
    public BoardListDto getBoards(BoardSearchCondition boardSearchCondition) {
        // 게시글 정보 조회
        BoardListDto boardListDto = boardService
                .getBoardList(boardSearchCondition);

        // 검색 기능에 필요한 카테고리
        List<CategoryDto> categoryDtoList = categoryService.getCategoryList();

        boardListDto.setCategoryDtoList(categoryDtoList);

        return boardListDto;
    }
}
