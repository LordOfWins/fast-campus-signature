package org.web.memorydb.user.db;

import java.util.List;

import org.springframework.stereotype.Service;
import org.web.memorydb.db.AbstractSimpleDataRepository;
import org.web.memorydb.user.model.UserEntitiy;

@Service
public class UserRepository extends AbstractSimpleDataRepository<UserEntitiy, Long> {

  //70점 이상인 사람을 찾아주는 메소드
  public List<UserEntitiy> findByScoreGreaterThanEqual(int score) {
    return this.findAll().stream().filter(userEntitiy -> userEntitiy.getScore() >= score).toList();

  }
}