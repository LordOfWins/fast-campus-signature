package org.web.simpleboard.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.simpleboard.common.Api;
import org.web.simpleboard.post.db.Post;
import org.web.simpleboard.post.model.PostRequest;
import org.web.simpleboard.post.model.PostViewRequest;
import org.web.simpleboard.post.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {
  private final PostService postService;

  @PostMapping
  public void create(@Valid @RequestBody PostRequest postRequest) {
    postService.create(postRequest);
  }

  @PostMapping("/view")
  public Post view(@Valid @RequestBody PostViewRequest postViewRequest) {
    return postService.view(postViewRequest);
  }

  @GetMapping("/all")
  public Api<List<Post>> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
    return postService.all(pageable);
  }

  @PostMapping("/delete")
  public void delete(@Valid @RequestBody PostViewRequest postViewRequest) {
    postService.delete(postViewRequest);

  }
}