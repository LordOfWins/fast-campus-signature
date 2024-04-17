package org.web.simpleboard.post.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.web.simpleboard.board.db.Board;
import org.web.simpleboard.reply.db.Reply;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JsonIgnore
  private Board board;

  private String userName;

  private String password;

  private String email;

  private String status;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime postedAt;

  @OneToMany(mappedBy = "post")
  @Builder.Default
  @JsonIgnore
  private List<Reply> replies = List.of();

}