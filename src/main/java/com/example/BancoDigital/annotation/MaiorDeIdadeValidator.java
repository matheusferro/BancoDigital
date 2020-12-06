package com.example.BancoDigital.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

public class MaiorDeIdadeValidator implements ConstraintValidator<MaiorDeIdade, LocalDate> {

    @Override
    public void initialize(MaiorDeIdade constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }
        int anoNasc = value.getYear();
        int anoAtual = LocalDate.now().getYear();
        if ((anoAtual - anoNasc) < 18) {
            return false;
        }
        return true;
    }
}
