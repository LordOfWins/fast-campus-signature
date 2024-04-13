package org.web.memorydb.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web.memorydb.user.db.UserRepository;
import org.web.memorydb.user.model.UserEntitiy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntitiy save(UserEntitiy user) {
    return userRepository.save(user);
  }

  public List<UserEntitiy> findAll() {
    return userRepository.findAll();
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

  public Optional<UserEntitiy> findById(Long id) {
    return userRepository.findById(id);
  }

  public List<UserEntitiy> findByScoreGreaterThanEqual(int score) {
    return userRepository.findByScoreGreaterThanEqual(score);
  }

  public UserEntitiy update(UserEntitiy userEntitiy) {
    return userRepository.update(userEntitiy);
  }
}