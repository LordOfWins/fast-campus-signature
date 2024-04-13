package org.web.memorydb.book.db.repository;

import org.springframework.stereotype.Service;
import org.web.memorydb.book.db.entity.BookEntitiy;
import org.web.memorydb.db.AbstractSimpleDataRepository;

@Service
public class BookRepository extends AbstractSimpleDataRepository<BookEntitiy, Long> {
  
}