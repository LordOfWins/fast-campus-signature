package org.web.simpleboard.reply.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.simpleboard.reply.db.Reply;
import org.web.simpleboard.reply.model.ReplyRequest;
import org.web.simpleboard.reply.service.ReplyService;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyApiController {
  private final ReplyService replyService;

  @PostMapping
  public Reply create(@Valid @RequestBody ReplyRequest replyRequest) {
    return replyService.create(replyRequest);
  }

}