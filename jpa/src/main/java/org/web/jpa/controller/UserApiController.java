package org.web.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web.jpa.db.User;
import org.web.jpa.db.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

  private final UserRepository userRepository;

  @GetMapping("/findAll")
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/name")
  public void addUser(@RequestParam String name) {
    var user = User.builder()
      .name(name)
      .build();
    userRepository.save(user);
  }
}