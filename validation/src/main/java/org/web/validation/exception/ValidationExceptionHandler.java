package org.web.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.web.validation.model.Api;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ResponseEntity<Api> validException(BindException exception) {
    log.error("error: {}", exception.getMessage());

    var errorMessageList = exception.getFieldErrors().stream().map(it -> {
      var format = "%s: {%s} 은 %s";
      return String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
    }).toList();
    var error = Api.Error.builder().errorsMessage(errorMessageList).build();

    var errorResponse = Api.builder()
        .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
        .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .error(error)
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

  }
}