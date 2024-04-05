package org.web.restapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.restapi.model.BookRequest;
import org.web.restapi.model.UserRequest;

@RestController
@RequestMapping("/api")
public class PostApiController {
  @PostMapping(path = "/post")
  public String post(
    @RequestBody BookRequest bookRequest
  ) {
    System.out.println("bookRequest = " + bookRequest);
    return bookRequest.toString();
  }

  @PostMapping(path = "/user")
  public String user(
    @RequestBody UserRequest userRequest
  ) {
    System.out.println("userRequest = " + userRequest);
    return userRequest.toString();
  }
}