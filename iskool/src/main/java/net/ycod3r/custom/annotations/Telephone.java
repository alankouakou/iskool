package net.ycod3r.custom.annotations;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import net.ycod3r.validators.ContactNumberValidator;

@Documented
@Constraint(validatedBy=ContactNumberValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Telephone {
	String message() default "Numero de telephone invalide!";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
