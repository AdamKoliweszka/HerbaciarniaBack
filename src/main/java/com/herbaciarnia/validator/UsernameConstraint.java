package com.herbaciarnia.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameConstraint {
    String message() default "Nazwa użtkownika już istnieje!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
