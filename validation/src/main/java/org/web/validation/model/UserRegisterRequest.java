package org.web.validation.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.web.validation.annotation.PhoneNumber;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
  // @NotBlank
  private String name;

  private String nickName;

  @Size(min = 1, max = 12)
  @NotBlank
  private String password;

  @NotNull
  @Min(1)
  @Max(200)
  private String age;

  @Email
  private String email;

  @PhoneNumber
  private String phoneNumber;

  @FutureOrPresent
  private LocalDateTime registerAt;

  @AssertTrue(message = "name 또는 password은 존재해야 합니다.")
  public boolean isNameCheck() {
    if (Objects.nonNull(name) && !name.isBlank()) {
      return true;
    }
    return Objects.nonNull(nickName) && !nickName.isBlank();
  }
}