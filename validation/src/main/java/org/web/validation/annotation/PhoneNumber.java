package org.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.web.validation.validation.PhoneNumberValid;

import jakarta.validation.Constraint;

@Constraint(validatedBy = PhoneNumberValid.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
  String message() default "Invalid phone number";

  String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";
}