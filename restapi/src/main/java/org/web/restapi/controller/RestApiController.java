package org.web.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web.restapi.model.BookQueryParam;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

  @GetMapping(path = "/hello")
  public String hello() {
    return "<html> <body> <h1> Hello, World! </h1> </body> </html>";
  }

  @GetMapping(path = "/echo/{message}/age/{age}/isMan/{isMan}")
  public String echo(@PathVariable("message") String message,
                     @PathVariable("age") int age, @PathVariable("isMan") boolean isMan) {
    System.out.println("Received message: " + message);
    System.out.println("age: " + age);
    System.out.println("isMan: " + isMan);
    return message.toUpperCase(Locale.ROOT);
  }

  @GetMapping(path = "/book")
  public void book(
    @RequestParam(name = "category") String category,
    @RequestParam(name = "issuedYear") String issuedYear,
    @RequestParam(name = "issued-month") String issuedMonth,
    @RequestParam(name = "issued_day") String issuedDay
  ) {
    System.out.println("Category: " + category);
    System.out.println("Issued Year: " + issuedYear);
    System.out.println("Issued Month: " + issuedMonth);
    System.out.println("Issued Day: " + issuedDay);
  }

  @GetMapping(path = "/book2")
  public void book2(
    BookQueryParam bookQueryParam
  ) {
    System.out.println("bookQueryParam = " + bookQueryParam);
  }

  @DeleteMapping(path = {"user/{userName}/delete", "user/{userName}/del"})
  public void delete(@PathVariable String userName) {
    log.info("userName {}", userName);
  }
}