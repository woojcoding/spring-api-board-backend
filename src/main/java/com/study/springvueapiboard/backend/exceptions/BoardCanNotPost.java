package com.study.springvueapiboard.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * 게시물을 작성할 수 없는 예외 클래스입니다.
 */
@Getter
@AllArgsConstructor
public class BoardCanNotPost extends RuntimeException {

    private BindingResult bindingResult;
}
