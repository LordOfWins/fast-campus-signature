package org.web.memorydb.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web.memorydb.user.model.UserEntitiy;
import org.web.memorydb.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

  private final UserService userService;

  @PostMapping
  public UserEntitiy create(@RequestBody UserEntitiy userEntitiy) {
    return userService.save(userEntitiy);
  }

  @GetMapping("/all")
  public List<UserEntitiy> findAll() {
    return userService.findAll();
  }

  //findById

  @GetMapping("/{id}")
  public UserEntitiy findById(@PathVariable("id") Long id) {
    var response = userService.findById(id);
    return response.orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다."));
  }

  //update
  @PostMapping("/update")
  public UserEntitiy update(@RequestBody UserEntitiy userEntitiy) {
    return userService.update(userEntitiy);
  }

  //delete
  @DeleteMapping("/id/{id}")
  public void delete(@PathVariable("id") Long id) {
    userService.deleteById(id);
  }

  //70점 이상인 사람을 찾아주는 메소드
  @GetMapping("/score")
  public List<UserEntitiy> findByScoreGreaterThanEqual(@RequestParam int score) {
    return userService.findByScoreGreaterThanEqual(score);
  }

}