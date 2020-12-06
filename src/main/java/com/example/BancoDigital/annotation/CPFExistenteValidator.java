package com.example.BancoDigital.annotation;

import com.example.BancoDigital.repository.cliente.ClienteRepository;
import com.example.BancoDigital.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Map;

public class CPFExistenteValidator implements ConstraintValidator<CPFExistente, String> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void initialize(CPFExistente constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("")  || value == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = clienteService.listaClientePorCpf(value);
        if (clienteExistente.isEmpty()) {
            return true;
        }
        return false;
    }
}
