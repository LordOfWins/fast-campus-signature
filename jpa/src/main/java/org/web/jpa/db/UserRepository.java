package org.web.jpa.db;


import org.springframework.data.jpa.repository.JpaRepository;

//User엔티티를 사용하고 id필드의 타입은 Long이다.
public interface UserRepository extends JpaRepository<User, Long> {
}