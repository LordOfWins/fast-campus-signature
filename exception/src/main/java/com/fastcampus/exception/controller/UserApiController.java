package com.fastcampus.exception.controller;

import com.fastcampus.exception.model.Api;
import com.fastcampus.exception.model.UserResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
  private static final List<UserResponse> userResponseList =
      List.of(
          UserResponse.builder().id("1").age(10).name("홍길동").build(),
          UserResponse.builder().id("2").age(15).name("홍길서").build(),
          UserResponse.builder().id("3").age(20).name("홍길남").build());

  @GetMapping("id/{userId}")
  public Api<UserResponse> getUser(@PathVariable("userId") String userId) {
    if (true) {
      throw new RuntimeException("사용자 찾을 수 없음");
    }
    var user = userResponseList.stream().filter(u -> u.getId().equals(userId)).findFirst().get();
    Api<UserResponse> api =
        Api.<UserResponse>builder()
            .resultCode(String.valueOf(HttpStatus.OK.value()))
            .resultMessage("OK")
            .data(user)
            .build();
    return api;
  }
}