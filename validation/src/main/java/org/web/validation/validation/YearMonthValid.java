package org.web.validation.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web.validation.annotation.YearMonth;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class YearMonthValid implements ConstraintValidator<YearMonth, String> {
  private static final Logger LOGGER = LoggerFactory.getLogger(YearMonthValid.class);
  private String pattern;

  @Override
  public void initialize(YearMonth constraintAnnotation) {
    this.pattern = constraintAnnotation.pattern();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    var reValue = value + "01";
    var rePattern = pattern + "dd";
    try {
      var date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
      System.out.println(date);
      return true;
    } catch (RuntimeJsonMappingException e) {
      LOGGER.error("yyyyMM 형식에 맞지 않습니다.", e);
      return false;
    }

  }
}