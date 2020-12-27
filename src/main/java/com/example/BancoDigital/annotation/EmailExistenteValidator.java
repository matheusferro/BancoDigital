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
    private ClienteRepository repository;

    @Override
    public void initialize(EmailExistente constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(repository == null){
            return true;
        }

        if(value.equals("")  || value == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = repository.findClienteByEmail(value);

        if (clienteExistente.isEmpty()) {
            return true;
        }
        return false;
    }
}
