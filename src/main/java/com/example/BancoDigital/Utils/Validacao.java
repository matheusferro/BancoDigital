package com.example.BancoDigital.Utils;


import com.example.BancoDigital.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Validacao {
    @Autowired
    private ClienteService service;

    public Validacao(ClienteService service) {
        this.service = service;
    }

    public boolean dtNascMaior18(LocalDate _dtNasc){
        if(_dtNasc == null) {
            return false;
        }
        int anoNasc = _dtNasc.getYear();
        int anoAtual = LocalDate.now().getYear();
        if ((anoAtual - anoNasc) < 18) {
            return false;
        }
        return true;
    }

    public boolean cpfExistente(String _cpf){
        if(_cpf.equals("")  && _cpf == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = service.listaClientePorCpf(_cpf);
        if (clienteExistente.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean emailExistente(String _email){
        if(_email.equals("")  && _email == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = service.listaClientePorEmail(_email);
        if (clienteExistente.isEmpty()) {
            return false;
        }
        return true;

    }
}

