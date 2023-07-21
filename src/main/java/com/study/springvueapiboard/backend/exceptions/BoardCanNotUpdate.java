package com.study.springvueapiboard.backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

/**
 * 게시물을 수정할 수 없는 예외 클래스입니다.
 */
@Getter
@AllArgsConstructor
public class BoardCanNotUpdate extends RuntimeException {

    private BindingResult bindingResult;
}
