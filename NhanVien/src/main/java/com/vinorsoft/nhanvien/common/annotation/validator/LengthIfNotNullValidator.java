package com.vinorsoft.nhanvien.common.annotation.validator;

import com.vinorsoft.nhanvien.common.annotation.LengthIfNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthIfNotNullValidator implements ConstraintValidator<LengthIfNotNull, String> {
    private int min;
    private int max;

    @Override
    public void initialize(LengthIfNotNull constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || (value.length() > min && value.length() <= max);
    }
}
