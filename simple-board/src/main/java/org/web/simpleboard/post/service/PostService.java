package org.web.simpleboard.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.web.simpleboard.board.db.BoardRepository;
import org.web.simpleboard.common.Api;
import org.web.simpleboard.common.Pagination;
import org.web.simpleboard.post.db.Post;
import org.web.simpleboard.post.db.PostRepository;
import org.web.simpleboard.post.model.PostRequest;
import org.web.simpleboard.post.model.PostViewRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;
  private final BoardRepository boardRepository;

  public Post create(PostRequest postRequest) {
    var board = boardRepository.findById(postRequest.getBoardId())
                               .orElseThrow(() -> new NoSuchElementException("보드가 없습니다."));
    var entity = Post.builder()
                     .board(board)
                     .userName(postRequest.getUserName())
                     .password(postRequest.getPassword())
                     .email(postRequest.getEmail())
                     .title(postRequest.getTitle())
                     .content(postRequest.getContent())
                     .status("REGISTERED")
                     .postedAt(LocalDateTime.now())
                     .build();
    return postRepository.save(entity);
  }


  /**
   * 게시글이 있는가?
   * 비밀번호가 있는가
   */
  public Post view(PostViewRequest postViewRequest) {
    return postRepository.findById(postViewRequest.getPostId()).map((Post post) -> {
      if (!post.getPassword().equals(postViewRequest.getPassword())) {
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
      }
      if ("UNREGISTERED".equals(post.getStatus())) {
        throw new NoSuchElementException("삭제된 게시글입니다.");
      }
      return post;
    }).orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));
  }

  public Api<List<Post>> all(Pageable pageable) {
    var list = postRepository.findAll(pageable);
    var pagination = Pagination.builder()
                               .page(list.getNumber())
                               .size(list.getSize())
                               .currentElements(list.getNumberOfElements())
                               .totalElements(list.getTotalElements())
                               .totalPages(list.getTotalPages())
                               .build();
    return Api.<List<Post>>builder().body(list.toList()).pagination(pagination).build();
  }

  public void delete(PostViewRequest postViewRequest) {
    postRepository.findById(postViewRequest.getPostId()).map((Post p) -> {
      if (!p.getPassword().equals(postViewRequest.getPassword())) {
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
      }
      p.setStatus("UNREGISTERED");
      return postRepository.save(p);
    }).orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));
  }
}