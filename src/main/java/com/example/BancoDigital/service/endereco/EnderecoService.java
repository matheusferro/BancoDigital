package com.example.BancoDigital.service.endereco;

import com.example.BancoDigital.model.Endereco;
import com.example.BancoDigital.repository.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco cadastrarEndereco(Endereco _endereco){
        return repository.save(_endereco);
    }

    public List<Map<String, String>> buscarEnderecoPorCliente(String _clienteId){
        return repository.findByTbClienteId(_clienteId);
    }
}
