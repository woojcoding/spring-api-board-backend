package com.study.springvueapiboard.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 게시물을 작성할 수 없는 예외 클래스입니다.
 */
@Getter
@AllArgsConstructor
public class InvalidPassword extends RuntimeException {

    private String message;
}
