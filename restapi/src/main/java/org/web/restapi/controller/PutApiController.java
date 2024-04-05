package org.web.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.restapi.model.UserRequest;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

  @PutMapping("/put")
  public String put(@RequestBody UserRequest userRequest) {
    log.info("userRequest = {}", userRequest);
    return userRequest.toString();
  }
}