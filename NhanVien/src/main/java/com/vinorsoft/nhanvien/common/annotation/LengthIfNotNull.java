package com.vinorsoft.nhanvien.common.annotation;

import com.vinorsoft.nhanvien.common.annotation.validator.LengthIfNotNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthIfNotNullValidator.class)
public @interface LengthIfNotNull {
    String message() default "Invalid field length";

    int min() default 0;

    int max() default 100;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}