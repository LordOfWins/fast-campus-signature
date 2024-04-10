package org.web.memorydb.entitiy;

import lombok.Data;

@Data
public abstract class AbstractEntity implements PrimaryKey {

  private Long id;
}