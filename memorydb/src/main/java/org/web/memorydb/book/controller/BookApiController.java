package org.web.memorydb.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.memorydb.book.db.entity.BookEntity;
import org.web.memorydb.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

  private final BookService bookService;

  @PostMapping("/create")
  public BookEntity create(@RequestBody BookEntity bookEntity) {
    return bookService.save(bookEntity);

  }

  @GetMapping("/all")
  public List<BookEntity> findAll() {
    return bookService.findAll();
  }

  @GetMapping("/id/{id}")
  public BookEntity findById(@PathVariable("id") Long id) {
    return bookService.findById(id);
  }

  @PutMapping("/update")
  public BookEntity update(@RequestBody BookEntity bookEntity) {
    return bookService.update(bookEntity);
  }

  @DeleteMapping("/id/{id}")
  public void delete(@PathVariable("id") Long id) {
    bookService.deleteById(id);
  }

}