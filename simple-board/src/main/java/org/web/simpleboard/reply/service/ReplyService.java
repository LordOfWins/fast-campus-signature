package org.web.simpleboard.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web.simpleboard.post.db.Post;
import org.web.simpleboard.post.db.PostRepository;
import org.web.simpleboard.reply.db.Reply;
import org.web.simpleboard.reply.db.ReplyRepository;
import org.web.simpleboard.reply.model.ReplyRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

  private static final String REGISTERED = "REGISTERED";
  private final ReplyRepository replyRepository;
  private final PostRepository postRepository;

  public Reply create(ReplyRequest replyRequest) {
    return replyRepository.save(Reply.builder()
                                     .post(postRepository.findById(replyRequest.getPostId()).orElseThrow())
                                     .userName(replyRequest.getUserName())
                                     .password(replyRequest.getPassword())
                                     .status(REGISTERED)
                                     .title(replyRequest.getTitle())
                                     .content(replyRequest.getContent())
                                     .repliedAt(LocalDateTime.now())
                                     .build());
  }

  //list
  public List<Reply> list(Long postId) {
    return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, REGISTERED);
  }

  public List<Reply> all(Post post) {
    return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(post.getId(), REGISTERED);
  }
}