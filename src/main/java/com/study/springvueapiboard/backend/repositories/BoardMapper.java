package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.BoardDetailResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardPostRequestDto;
import com.study.springvueapiboard.backend.dtos.BoardResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardUpdateRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface BoardMapper {

    /**
     * 게시글 목록 조회에서  검색 조건에 따라 게시글 정보들을 List로 가져오는 메서드
     *
     * @param boardSearchCondition 검색 조건
     * @param rowBounds            페이지네이션에 사용할 클래스
     * @return List<BoardResponseDto>       게시글 정보 List
     */
    List<BoardResponseDto> getBoardList(BoardSearchCondition boardSearchCondition,
                                        RowBounds rowBounds);

    /**
     * 게시글 목록 조회에서  검색 조건에 따라 검색 되는 게시글의 총 수
     *
     * @param boardSearchCondition 검색 조건
     * @return 게시글 조회 건 수
     */
    int getBoardCount(BoardSearchCondition boardSearchCondition);

    /**
     * 조회수 증가 메서드
     *
     * @param boardId 게시글 Id
     */
    void updateViews(int boardId);

    /**
     * 게시글의 자세한 정보를 가져오는 메서드
     *
     * @param boardId 게시글 Id
     * @return BoardDetailResponseDto 게시글의 자세한 정보
     */
    BoardDetailResponseDto getBoard(int boardId);

    /**
     * 게시물을 작성하는 메서드
     *
     * @param boardPostRequestDto 게시물 작성 요청 DTO
     */
    void postBoard(BoardPostRequestDto boardPostRequestDto);

    /**
     * 게시글을 수정하는 메서드
     *
     * @param boardId               게시글 Id
     * @param boardUpdateRequestDto 게시글을 수정하는데 필요한 Dto
     */
    void updateBoard(int boardId, BoardUpdateRequestDto boardUpdateRequestDto);
}
