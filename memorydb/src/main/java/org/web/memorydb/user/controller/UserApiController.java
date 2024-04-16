package org.web.memorydb.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web.memorydb.user.model.UserEntity;
import org.web.memorydb.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

  private final UserService userService;

  @PostMapping
  public UserEntity create(@RequestBody UserEntity userEntity) {
    return userService.save(userEntity);
  }

  @GetMapping("/all")
  public List<UserEntity> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public UserEntity findById(@PathVariable("id") Long id) {
    var response = userService.findById(id);
    return response.orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다."));
  }

  //update
  @PutMapping("/update")
  public UserEntity update(@RequestBody UserEntity userEntity) {
    return userService.update(userEntity);
  }

  //delete
  @DeleteMapping("/id/{id}")
  public void delete(@PathVariable("id") Long id) {
    userService.deleteById(id);
  }

  //70점 이상인 사람을 찾아주는 메소드
  @GetMapping("/score")
  public List<UserEntity> findAllScoreGreaterThanEqual(@RequestParam("score") int score) {
    return userService.findAllScoreGreaterThanEqual(score);
  }

  //score가 start와 end 사이에 있는 사람을 찾아주는 메소드
  @GetMapping("/score/between")
  public List<UserEntity> findByScoreLessThanEqualOrScoreGreaterThanEqual(@RequestParam("start") int start,
      @RequestParam("end") int end) {
    return userService.findByScoreLessThanEqualOrScoreGreaterThanEqual(start, end);
  }
}