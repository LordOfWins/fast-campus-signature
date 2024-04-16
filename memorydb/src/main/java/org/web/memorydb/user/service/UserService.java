package org.web.memorydb.user.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web.memorydb.user.db.UserRepository;
import org.web.memorydb.user.model.UserEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

  public Optional<UserEntity> findById(Long id) {
    return userRepository.findById(id);
  }

  public UserEntity update(UserEntity userEntity) {
    Optional<UserEntity> user = userRepository.findById(userEntity.getId());
    if (user.isPresent()) {
      user.get().setId(userEntity.getId());
      user.get().setName(userEntity.getName());
      user.get().setScore(userEntity.getScore());
      return userRepository.save(userEntity);
    } else {
      throw new NoSuchElementException();
    }
  }

  public List<UserEntity> findAllScoreGreaterThanEqual(int score) {
    return userRepository.findByScoreGreaterThanEqual(score);
  }

  public List<UserEntity> findByScoreLessThanEqualOrScoreGreaterThanEqual(int start, int end) {
    return userRepository.findByScoreLessThanEqualOrScoreGreaterThanEqualQuery(start, end);
  }
}