package org.web.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web.simpleboard.board.db.Board;
import org.web.simpleboard.board.model.BoardDto;
import org.web.simpleboard.post.service.PostConverter;

@Service
@RequiredArgsConstructor
public class BoardConverter {
  private final PostConverter postConverter;

  public BoardDto toBoardDto(Board board) {
    var posts = board.getPosts().stream().map(postConverter::toPostDto).toList();
    return BoardDto.builder()
                   .id(board.getId())
                   .boardName(board.getBoardName())
                   .status(board.getStatus())
                   .posts(posts)
                   .build();
  }
}