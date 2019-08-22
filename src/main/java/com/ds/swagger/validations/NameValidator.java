package com.ds.swagger.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Annotation will work at RUNTIME
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //Annotation can be applied either on METHOD or on FIELD
@Constraint(validatedBy = NameValidatorImpl.class) //CustomValidator class will validate the values
public @interface NameValidator {
    String message() default "The name David isn't accepted";

    String value() default "David";

    Class<?>[] groups() default {}; //Required by Constraint

    Class<? extends Payload>[] payload() default {}; //Required by Constraint
}
