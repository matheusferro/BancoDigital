package com.example.BancoDigital.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Valida idade do cliente
 *
 * @author Matheus Ferro
 */
@Documented
@Constraint(validatedBy = { MaiorDeIdadeValidator.class })
@Target({FIELD})
@Retention(RUNTIME)
public @interface MaiorDeIdade {

    String message() default "É preciso ser maior de idade para realizar o cadastro.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
