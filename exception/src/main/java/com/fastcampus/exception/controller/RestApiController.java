package com.fastcampus.exception.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
  @GetMapping("/hello")
  public void hello() {
    var list = List.of("hello");
    var element = list.get(1);
    log.info("element: {}", element);
  }
}