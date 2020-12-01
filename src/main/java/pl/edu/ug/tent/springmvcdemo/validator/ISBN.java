package pl.edu.ug.tent.springmvcdemo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ISBNValidator.class)
public @interface ISBN {

    String message() default "ISBN jest niepoprawny";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}