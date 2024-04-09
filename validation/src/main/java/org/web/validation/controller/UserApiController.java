package org.web.validation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.validation.model.Api;
import org.web.validation.model.UserRegisterRequest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

  @PostMapping()
  public Api<UserRegisterRequest> register(@Valid @RequestBody Api<UserRegisterRequest> request,
      Errors errors) {
    log.info("request: {}", request);

    var body = request.getData();

    return Api.<UserRegisterRequest>builder()
        .resultCode(String.valueOf(HttpStatus.OK.value()))
        .resultMessage(HttpStatus.OK.getReasonPhrase())
        .data(body)
        .build();
  }
}