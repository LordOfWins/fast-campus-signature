package org.web.memorydb.book.db.entity;

import java.math.BigDecimal;

import org.web.memorydb.entitiy.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntitiy extends AbstractEntity {

  private String title;
  private String category;
  private BigDecimal amount;

}