package org.web.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface Repository<T, I> {
  //create
  T save(T data);

  //read
  Optional<T> findById(I id);

  List<T> findAll();

  //update
  T update(T data);

  //delete
  void deleteById(I id);
}