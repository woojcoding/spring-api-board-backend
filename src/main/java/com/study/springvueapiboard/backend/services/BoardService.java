package com.study.springvueapiboard.backend.services;

import com.study.springvueapiboard.backend.dtos.BoardDetailResponseDto;
import com.study.springvueapiboard.backend.dtos.BoardListDto;
import com.study.springvueapiboard.backend.dtos.BoardResponseDto;
import com.study.springvueapiboard.backend.repositories.BoardRepository;
import com.study.springvueapiboard.backend.repositories.BoardSearchCondition;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 목록 조회에서 검색 조건에 따라 게시글 정보들을 List로 받도록
     * Repository에 요청하기 위해 사용하는 메서드
     *
     * @param boardSearchCondition 검색 조건
     * @return List<BoardResponseDto>               게시글 정보 List
     */
    public BoardListDto getBoardList(BoardSearchCondition boardSearchCondition) {

        /**
         * 페이지 네이션을 위한 rowBounds 인스턴스 생성
         */
        int pageNum = boardSearchCondition.getPageNum();

        int pageSize = 10;

        int offset = (pageNum - 1) * pageSize;

        RowBounds rowBounds = new RowBounds(offset, pageSize);

        /**
         *  db에서 페이지네이션을 적용한 게시글 조회
         */
        List<BoardResponseDto> boardResponseDtoList =
                boardRepository.getBoardList(boardSearchCondition, rowBounds);

        int totalBoardCount =
                boardRepository.getBoardCount(boardSearchCondition);

        return BoardListDto.builder()
                .boardResponseDtoList(boardResponseDtoList)
                .totalBoardCount(totalBoardCount)
                .build();
    }

    /**
     * 조회수 증가하는 메서드
     *
     * @param boardId 게시글 Id
     */
    public void updateViews(int boardId) {
        boardRepository.updateViews(boardId);
    }

    /**
     * 게시글의 정보를 가져오는 메서드
     *
     * @param boardId 조회할 게시글의 Id
     * @return BoardDetailResponseDto 게시글 정보
     */
    public BoardDetailResponseDto getBoard(int boardId) {
        BoardDetailResponseDto boardDetailResponseDto =
                boardRepository.getBoard(boardId);

        return boardDetailResponseDto;
    }
}
