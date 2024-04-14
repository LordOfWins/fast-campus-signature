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
import org.web.memorydb.book.db.entity.BookEntitiy;
import org.web.memorydb.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

  private final BookService bookService;

  @PostMapping("/create")
  public BookEntitiy create(@RequestBody BookEntitiy bookEntitiy) {
    return bookService.save(bookEntitiy);

  }

  @GetMapping("/all")
  public List<BookEntitiy> findAll() {
    return bookService.findAll();
  }

  @GetMapping("/id/{id}")
  public BookEntitiy findById(@PathVariable("id") Long id) {
    var response = bookService.findById(id);
    return response.orElseThrow(() -> new IllegalArgumentException("해당하는 책이 없습니다."));
  }

  @PutMapping("/update")
  public BookEntitiy update(@RequestBody BookEntitiy bookEntitiy) {
    return bookService.update(bookEntitiy);
  }

  @DeleteMapping("/id/{id}")
  public void delete(@PathVariable("id") Long id) {
    bookService.deleteById(id);
  }

}