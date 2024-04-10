package org.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.web.validation.validation.YearMonthValid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

@Constraint(validatedBy = YearMonthValid.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {
  String message() default "yyyyMM 형식에 맞지 않습니다.";

  String pattern() default "yyyyMMdd";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}