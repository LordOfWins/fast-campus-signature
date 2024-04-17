package org.web.simpleboard.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web.simpleboard.board.db.Board;
import org.web.simpleboard.board.db.BoardRepository;
import org.web.simpleboard.board.model.BoardDto;
import org.web.simpleboard.board.model.BoardRequest;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;
  private final BoardConverter boardConverter;

  public BoardDto create(BoardRequest boardRequest) {
    var entity = Board.builder().boardName(boardRequest.getBoardName()).build();
    return boardConverter.toBoardDto(boardRepository.save(entity));
  }

  @Transactional
  public BoardDto view(Long id) {
    var board = boardRepository.findById(id).orElseThrow();
    return boardConverter.toBoardDto(board);
  }
}