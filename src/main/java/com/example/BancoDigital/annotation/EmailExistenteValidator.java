package com.example.BancoDigital.annotation;

import com.example.BancoDigital.repository.cliente.ClienteRepository;
import com.example.BancoDigital.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

public class EmailExistenteValidator implements ConstraintValidator<EmailExistente, String> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void initialize(EmailExistente constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("")  || value == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = clienteService.listaClientePorEmail(value);
        if (clienteExistente.isEmpty()) {
            return true;
        }
        return false;
    }
}
