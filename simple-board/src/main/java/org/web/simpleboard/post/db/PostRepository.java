package org.web.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
  //  select * from post where id=? and status =? order by id desc limit 1
  Optional<Post> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}