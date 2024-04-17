package org.web.simpleboard.reply.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.web.simpleboard.post.db.Post;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reply", schema = "simple_board")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JsonIgnore
  @ToString.Exclude
  private Post post;

  private String userName;

  private String password;

  private String status;

  private String title;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime repliedAt;


}