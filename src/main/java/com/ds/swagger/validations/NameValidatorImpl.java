package com.ds.swagger.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class NameValidatorImpl implements ConstraintValidator<NameValidator, String> {
    public String message;
    public String value;


    @Override
    public void initialize(NameValidator constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String toBeValidate, ConstraintValidatorContext constraintValidatorContext) {
        return !Objects.equals(value, toBeValidate );
    }
}
