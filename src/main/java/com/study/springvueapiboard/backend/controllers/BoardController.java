package com.study.springvueapiboard.backend.controllers;

import com.study.springvueapiboard.backend.dtos.BoardDetailResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardListDto;
import com.study.springvueapiboard.backend.dtos.BoardPostRequestDto;
import com.study.springvueapiboard.backend.dtos.CategoryDto;
import com.study.springvueapiboard.backend.dtos.CommentResponseDto;
import com.study.springvueapiboard.backend.dtos.FileDto;
import com.study.springvueapiboard.backend.exceptions.BoardCanNotPost;
import com.study.springvueapiboard.backend.repositories.BoardSearchCondition;
import com.study.springvueapiboard.backend.services.BoardService;
import com.study.springvueapiboard.backend.services.CategoryService;
import com.study.springvueapiboard.backend.services.CommentService;
import com.study.springvueapiboard.backend.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * The type Board controller.
 */
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
     * @return board boards
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

    /**
     * 게시글에 대한 상세정보를 리턴해주는 메서드
     *
     * @param boardId 조회할 게시글 Id
     * @return the board
     */
    @GetMapping("/boards/free/view/{boardId}")
    public BoardDetailResponseDto getBoard(
            @PathVariable("boardId") int boardId
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

    /**
     * 카테고리 List를 반환해주는 메서드
     *
     * @return 카테고리 List
     */
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getCategoryList() {
        return categoryService.getCategoryList();
    }

    /**
     * 게시글을 등록 요청하는 메서드
     *
     * @param boardPostRequestDto 게시글 등록에 필요한 Dto
     * @param bindingResult       유효성 검증을 담는 객체
     * @return boardId            작성한 게시글의 Id
     * @throws IOException the io exception
     */
    @PostMapping("/board/free/write")
    @ResponseStatus(HttpStatus.CREATED)
    public int postBoard(
            @Valid @ModelAttribute BoardPostRequestDto boardPostRequestDto,
            BindingResult bindingResult
    ) throws IOException {
        // 유효성 검증
        if (bindingResult.hasErrors()) {
            throw new BoardCanNotPost(bindingResult);
        }

        // 게시글을 post
        boardService.postBoard(boardPostRequestDto);

        // 게시글에 첨부된 파일 업로드
        int boardId = boardPostRequestDto.getBoardId();

        MultipartFile[] files = boardPostRequestDto.getFiles();

        List<FileDto> fileDtoList = fileService.saveFiles(files, boardId);

        fileService.uploadFiles(fileDtoList);

        return boardId;
    }
}
