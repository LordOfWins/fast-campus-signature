package org.web.simpleboard.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.simpleboard.board.model.BoardDto;
import org.web.simpleboard.board.model.BoardRequest;
import org.web.simpleboard.board.service.BoardService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

  private final BoardService boardService;

  @PostMapping
  public BoardDto create(@Valid @RequestBody BoardRequest boardRequest) {
    return boardService.create(boardRequest);
  }

  @GetMapping("/id/{id}")
  public BoardDto view(@PathVariable("id") Long id) {
    return boardService.view(id);
  }
}