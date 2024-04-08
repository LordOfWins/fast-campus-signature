package com.fastcampus.exception.exception;

import com.fastcampus.exception.controller.RestApiController;
import com.fastcampus.exception.controller.RestBController;
import com.fastcampus.exception.model.Api;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestBController.class})
@Order(1)
public class RestApiExceptionHandler {
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<Api> exception(Exception e) {
    log.error("exception", e);
    var response =
        Api.builder()
            .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

  @ExceptionHandler(value = {IndexOutOfBoundsException.class})
  public ResponseEntity outOfBoundsException(IndexOutOfBoundsException e) {
    log.error("배열 범위 초과 : {}", e.getMessage(), e);
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(value = {NoSuchElementException.class})
  public ResponseEntity<Api> noSuchElement(NoSuchElementException e) {
    log.error("찾을 수 없음 : {}", e.getMessage(), e);
    var response =
        Api.builder()
            .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
            .resultMessage(e.getMessage())
            .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}