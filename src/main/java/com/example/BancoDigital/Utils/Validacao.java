package com.example.BancoDigital.Utils;


import com.example.BancoDigital.service.cliente.ClienteService;
import com.example.BancoDigital.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Validacao {
    @Autowired
    private ClienteService serviceCliente;
    public Validacao(ClienteService serviceCliente) {
        this.serviceCliente = serviceCliente;
    }

    @Autowired
    private EnderecoService serviceEndereco;
    public Validacao(EnderecoService serviceEndereco) { this.serviceEndereco = serviceEndereco; }


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
        List<Map<String, String>> clienteExistente = serviceCliente.listaClientePorCpf(_cpf);
        if (clienteExistente.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean emailExistente(String _email){
        if(_email.equals("")  && _email == null) {
            return false;
        }
        List<Map<String, String>> clienteExistente = serviceCliente.listaClientePorEmail(_email);
        if (clienteExistente.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean enderecoDeClienteExistente(String _idCliente){
        if(_idCliente.equals("") || _idCliente == null){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Erro ao validar endereço de cliente.");
        }
        List<Map<String, String>> enderecoExistente = serviceEndereco.buscarEnderecoPorCliente(_idCliente);
        if(enderecoExistente.isEmpty()){
            return false;
        }
        return true;
    }
}

