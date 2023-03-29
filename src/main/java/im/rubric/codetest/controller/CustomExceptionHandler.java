package im.rubric.codetest.controller;

import im.rubric.codetest.dto.io.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 오류 응답을 위한 controller advice 입니다.
 * 테스트 진행을 위한 코드 작성과는 관련이 없으니 수정하지 말아주세요.
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /** 공통 exception 처리 */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse unexpectedException(Exception e) {
        e.printStackTrace();
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getClass().getSimpleName(), "Server error occurred (" + e.getMessage() + ")");
    }
}
