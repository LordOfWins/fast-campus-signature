package com.fastcampus.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.fastcampus.exception.controller")
public class RestApiExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity exception(Exception e) {
    log.error("일반적인 예외: {}", e.getMessage(), e);
    return ResponseEntity.ok().build();
  }

  @ExceptionHandler(value = {IndexOutOfBoundsException.class})
  public ResponseEntity outOfBoundsException(IndexOutOfBoundsException e) {
    log.error("배열 범위 초과 : {}", e.getMessage(), e);
    return ResponseEntity.ok().build();
  }
}