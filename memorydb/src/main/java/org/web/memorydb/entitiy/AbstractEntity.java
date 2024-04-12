package org.web.memorydb.entitiy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractEntity implements PrimaryKey {

  private Long id;
}