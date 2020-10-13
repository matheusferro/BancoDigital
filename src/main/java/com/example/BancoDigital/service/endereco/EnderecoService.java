package com.example.BancoDigital.service.endereco;

import com.example.BancoDigital.dto.model.EnderecoDTO;
import com.example.BancoDigital.model.Endereco;
import com.example.BancoDigital.repository.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoDTO cadastrarEndereco(EnderecoDTO _enderecodto){
        try {
//        NÃO REQUISITADO VALIDAÇÃO
//        Validacao validacao = new Validacao(this);
//        if(validacao.enderecoDeClienteExistente(_enderecodto.getClienteId().toString())){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um endereço cadastrado para esse cliente.");
//        }
            Endereco endereco = repository.save(_enderecodto.convertDTOToEntity());
            return endereco.convertEntityToDTO();
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }

    public List<Map<String, String>> buscarEnderecoPorCliente(String _clienteId){
        try {
            return repository.findByTbClienteId(_clienteId);
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }
}
