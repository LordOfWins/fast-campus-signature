package org.web.memorydb.book.service;

import org.springframework.stereotype.Service;
import org.web.memorydb.book.db.entity.BookEntitiy;
import org.web.memorydb.db.AbstractSimpleDataRepository;

@Service
public class BookService extends AbstractSimpleDataRepository<BookEntitiy, Long> {
  
}