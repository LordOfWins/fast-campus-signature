package org.web.validation.validation;

import java.util.regex.Pattern;

import org.web.validation.annotation.PhoneNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PhoneNumberValid implements ConstraintValidator<PhoneNumber, String> {

  private String regexp;

  @Override
  public void initialize(PhoneNumber constraintAnnotation) {
    this.regexp = constraintAnnotation.regexp();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Pattern.matches(regexp, value);
  }
}