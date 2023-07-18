package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    /**
     * 게시글 목록 조회에서 검색 조건에 따라 게시글 정보들을 List로 가져오는 메서드
     *
     * @param boardSearchCondition 검색 조건
     * @param rowBounds            페이지네이션을 위한 클래스
     * @return List<BoardResponseDto>       게시글 정보 List
     */
    public List<BoardResponseDto> getBoardList(
            BoardSearchCondition boardSearchCondition, RowBounds rowBounds
    ) {
        return boardMapper.getBoardList(boardSearchCondition, rowBounds);
    }

    /**
     * 게시글 목록 조회에서  검색 조건에 따라 검색 되는 게시글의 총 수
     *
     * @param boardSearchCondition 검색 조건
     * @return 게시글 조회 건 수
     */
    public int getBoardCount(BoardSearchCondition boardSearchCondition) {
        return boardMapper.getBoardCount(boardSearchCondition);
    }
}