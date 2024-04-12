package org.web.memorydb.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.web.memorydb.entitiy.AbstractEntity;

public abstract class AbstractSimpleDataRepository<T extends AbstractEntity, I> implements DataRepository<T, I> {

  private final Map<Long, T> dataMap = new HashMap<>();
  private long index;

  //create

  @Override
  public T save(T data) {
    if (Objects.isNull(data)) {
      throw new IllegalArgumentException("Data cannot be null");
    }
    data.setId(++index);
    dataMap.put(data.getId(), data);
    return data;
  }

  //read

  @Override
  public Optional<T> findById(I id) {
    return dataMap.values().stream().filter(data -> data.getId().equals(id)).findFirst();
  }

  @Override
  public List<T> findAll() {
    return List.copyOf(dataMap.values());
  }

  //update
  @Override
  public T update(T data) {
    if (Objects.isNull(data)) {
      throw new IllegalArgumentException("Data cannot be null");
    }
    var prevData = dataMap.values().stream().filter(d -> d.getId().equals(data.getId())).findFirst();

    if (prevData.isPresent()) {
      dataMap.put(data.getId(), data);
    } else {
      throw new IllegalArgumentException("Data is not exist");
    }
    return data;
  }

  //delete

  @Override
  public void deleteById(I i) {
    var deleteEntity = dataMap.values().stream().filter(data -> data.getId().equals(i)).findFirst();
    if (deleteEntity.isPresent()) {
      dataMap.remove(deleteEntity.get().getId());
    } else {
      throw new IllegalArgumentException("Data is not exist");
    }
  }
}