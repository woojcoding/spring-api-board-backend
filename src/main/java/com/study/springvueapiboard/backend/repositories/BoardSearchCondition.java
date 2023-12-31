package com.study.springvueapiboard.backend.repositories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 게시글 검색 조건
 */
@Getter
@Setter
@NoArgsConstructor
public class BoardSearchCondition {

    private int pageNum = 1; // 현재 페이지

    private String startDate; // 검색 시작일

    private String endDate; // 검색 종료일

    private String category; // 카테고리

    private String keyword; // 검색 키워드
}
