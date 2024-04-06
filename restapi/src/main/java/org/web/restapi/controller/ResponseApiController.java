package org.web.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.restapi.model.UserRequest;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {
  @GetMapping
  public ResponseEntity<UserRequest> user() {
    var user = new UserRequest("steve", 23, "010-1111-2222", true);
    user.setUserName("steve");
    user.setUserAge(23);
    user.setEmail("010-1111-2222");

    log.info("User: {}", user);

    return ResponseEntity.ok(user);
  }
}