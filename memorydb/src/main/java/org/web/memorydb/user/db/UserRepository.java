package org.web.memorydb.user.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.web.memorydb.user.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  List<UserEntity> findByScoreGreaterThanEqual(int score);

  List<UserEntity> findByScoreLessThanEqualOrScoreGreaterThanEqual(int start, int end);

  @Query("select u from user u where u.score <= :end or u.score >= :start")
  List<UserEntity> findByScoreLessThanEqualOrScoreGreaterThanEqualQuery(@Param("start") int start,
      @Param("end") int end);

}