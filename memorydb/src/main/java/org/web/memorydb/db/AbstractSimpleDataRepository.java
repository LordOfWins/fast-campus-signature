package org.web.memorydb.db;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.web.memorydb.entitiy.Entity;

public abstract class AbstractSimpleDataRepository<T extends Entity, I> implements DataRepository<T, I> {

  private final Map<Long, T> dataMap = new HashMap<>();
  private final Comparator<I> comparator = new Comparator<I>() {
    @Override
    public int compare(I o1, I o2) {
      return Long.compare((Long)o1, (Long)o2);
    }
  };
  private long index;

  //create

  @Override
  public T save(T data) {
    if (Objects.isNull(data)) {
      throw new IllegalArgumentException("Data cannot be null");
    }
    //db에 데이터가 있는가?
    var prevData = dataMap.get(data.getId());

    if (prevData != null) {
      //db에 데이터가 있으면 수정
      dataMap.put(data.getId(), data);
    } else {
      //db에 데이터가 없으면 추가
      data.setId(index++);
      dataMap.put(data.getId(), data);
    }
    return data;
  }

  //read

  @Override
  public Optional<T> findById(I id) {
    return dataMap.values().stream().filter(data -> data.getId().equals(id)).findFirst();
  }

  @Override
  public List<T> findAll() {
    return dataMap.values().stream().sorted(Comparator.comparing(T::getId)).toList();
  }

  //delete

  @Override
  public void deleteById(I i) {
    var deleteEntity = dataMap.values().stream().filter(data -> data.getId().equals(i)).findFirst();

    if (deleteEntity.isPresent()) {
      dataMap.remove(deleteEntity.get().getId());
    }
  }
}