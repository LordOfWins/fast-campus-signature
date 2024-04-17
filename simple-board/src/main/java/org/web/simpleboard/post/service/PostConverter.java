package org.web.simpleboard.post.service;

import org.springframework.stereotype.Service;
import org.web.simpleboard.post.db.Post;
import org.web.simpleboard.post.model.PostDto;

@Service
public class PostConverter {
  public PostDto toPostDto(Post post) {
    return PostDto.builder()
                  .id(post.getId())
                  .userName(post.getUserName())
                  .status(post.getStatus())
                  .email(post.getEmail())
                  .password(post.getPassword())
                  .title(post.getTitle())
                  .content(post.getContent())
                  .postedAt(post.getPostedAt())
                  .boardId(post.getBoard().getId())
                  .build();
  }
}