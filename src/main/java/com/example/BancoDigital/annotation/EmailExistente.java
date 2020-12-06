package com.example.BancoDigital.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Valida existencia do email do cliente.
 *
 * @author Matheus Ferro
 */
@Documented
@Constraint(validatedBy = { EmailExistenteValidator.class })
@Target({FIELD})
@Retention(RUNTIME)
public @interface EmailExistente {
    String message() default "E-mail já existente.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
