package com.example.BancoDigital.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Valida existencia do CPF do cliente.
 *
 * @author Matheus Ferro
 */
@Documented
@Constraint(validatedBy = { CPFExistenteValidator.class })
@Target({FIELD})
@Retention(RUNTIME)
public @interface CPFExistente {

    String message() default "CPF já cadastrado";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
