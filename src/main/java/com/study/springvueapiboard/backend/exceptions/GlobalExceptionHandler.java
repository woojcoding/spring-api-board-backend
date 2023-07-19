package com.study.springvueapiboard.backend.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 전역 예외 처리를 담당하는 클래스입니다.
 */
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * BoardCanNotPost 예외가 발생하였을 떄 예외처리하는 메서드
     * <p>
     * 에러메세지를 담은 ResponseEntity를 반환해줌
     *
     * @param ex 예외
     * @return ResponseEntity<List<String>> 에러메세지를 담은 ResponseEntity
     */
    @ExceptionHandler(BoardCanNotPost.class)
    public ResponseEntity<List<String>> handleBoardCanNotPost(
            BoardCanNotPost ex) {
        // 유효성 검증 실패 시 에러 메시지 처리
        BindingResult bindingResult = ex.getBindingResult();

        List<ObjectError> errorList = bindingResult.getAllErrors();

        List<String> errorMessageList = new ArrayList<>();

        for (ObjectError error : errorList) {
            errorMessageList.add(error.getDefaultMessage());
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessageList);
    }
}
