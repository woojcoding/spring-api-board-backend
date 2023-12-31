package com.study.springvueapiboard.backend.repositories;

import com.study.springvueapiboard.backend.dtos.BoardDetailResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardPostRequestDto;
import com.study.springvueapiboard.backend.dtos.BoardResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardUpdateRequestDto;
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

    /**
     * 조회수 증가 메서드
     *
     * @param boardId 게시글 Id
     */
    public void updateViews(int boardId) {
        boardMapper.updateViews(boardId);
    }

    /**
     * 게시글의 자세한 정보를 가져오는 메서드
     *
     * @param boardId 게시글 Id
     * @return BoardDetailResponseDto 게시글의 자세한 정보
     */
    public BoardDetailResponseDto getBoard(int boardId) {
        return boardMapper.getBoard(boardId);
    }

    /**
     * 게시물을 작성하는 메서드
     *
     * @param boardPostRequestDto 게시물 작성 요청 DTO
     */
    public void postBoard(BoardPostRequestDto boardPostRequestDto) {
        boardMapper.postBoard(boardPostRequestDto);
    }

    /**
     * 게시글을 수정하는 메서드
     *
     * @param boardId               게시글 Id
     * @param boardUpdateRequestDto 게시글을 수정하는데 필요한 Dto
     */
    public void updateBoard(int boardId,
                            BoardUpdateRequestDto boardUpdateRequestDto
    ) {
        boardMapper.updateBoard(boardId, boardUpdateRequestDto);
    }

    /**
     * 비밀번호 검증을 위해 비밀번호를 가져오는 메서드
     *
     * @param boardId 게시글 Id
     * @return 비밀번호 password
     */
    public String getPassword(int boardId) {
        return boardMapper.getPassword(boardId);
    }

    /**
     * 게시글을 삭제하는 메서드
     *
     * @param boardId 게시글 Id
     */
    public void deleteBoard(int boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
