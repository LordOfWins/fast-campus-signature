package org.web.validation.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Api<T> {
  private String resultCode;
  private String resultMessage;
  @Valid
  private T data;
  private Error error;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  
  public static class Error {
    private List<String> errorsMessage;
  }
}