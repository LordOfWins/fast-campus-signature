package org.web.memorydb.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.web.memorydb.book.db.entity.BookEntity;
import org.web.memorydb.book.db.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public BookEntity save(BookEntity bookEntity) {
    return bookRepository.save(bookEntity);
  }

  public List<BookEntity> findAll() {
    return bookRepository.findAll();
  }

  public BookEntity findById(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 책이 없습니다."));
  }

  public BookEntity update(BookEntity bookEntity) {
    Optional<BookEntity> book = bookRepository.findById(bookEntity.getId());
    if (book.isPresent()) {
      bookEntity.setId(book.get().getId());
      bookEntity.setTitle(book.get().getTitle());
      bookEntity.setCategory(book.get().getCategory());
      bookEntity.setAmount(book.get().getAmount());
      return bookRepository.save(bookEntity);
    } else {
      throw new IllegalArgumentException("해당하는 책이 없습니다.");
    }
  }

  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }
}