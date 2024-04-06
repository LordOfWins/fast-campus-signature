package com.fastcampus.exception.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/b")
public class RestBController {
  @GetMapping("/hello")
  public void hello() {
    throw new NumberFormatException("number format exception");
  }

  // @ExceptionHandler(value = {NumberFormatException.class})
  // public ResponseEntity<?> numberFormatException(NumberFormatException e) {
  //   log.error("숫자 형식 예외: {}", e.getMessage(), e);
  //   return ResponseEntity.ok().build();
  // }
}