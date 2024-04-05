package org.web.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.BindParam;

@Data
@AllArgsConstructor

public class BookQueryParam {
  @BindParam("category")
  private String category;

  @BindParam("issuedYear")
  private String issuedYear;

  @BindParam("issued-month")
  private String issuedMonth;

  @BindParam("issued_day")
  private String issuedDay;
}