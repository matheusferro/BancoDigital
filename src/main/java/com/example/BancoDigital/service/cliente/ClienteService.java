package com.example.BancoDigital.service.cliente;

import com.example.BancoDigital.Utils.Validacao;
import com.example.BancoDigital.dto.model.ClienteDTO;
import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;


@Service
public class ClienteService implements ICliente {
//
//    private final ClienteDAO clienteDAO;
//
//    @Autowired
//    public ClienteService(@Qualifier("mySql") ClienteDAO clienteDAO) {
//        this.clienteDAO = clienteDAO;
//    }
    @Autowired
    private ClienteRepository repository;

    public ClienteDTO cadastroCliente(ClienteDTO _clientedto){
        try {
            Validacao validacao = new Validacao(this);
            if (!validacao.dtNascMaior18(_clientedto.getDtNasc())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário ser maior de idade.");
            }
            if (validacao.emailExistente(_clientedto.getEmail())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email existente.");
            }
            if (validacao.cpfExistente(_clientedto.getCpf())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF existente.");
            }
            Cliente cliente = repository.save(_clientedto.convertDTOToEntity());

            return cliente.convertEntityToDTO();
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }

    public List<Cliente> listaTodosClientes(){
        return repository.findAll();
    }

    public List<Map<String, String>> listaClientePorCpf(String _cpf){
        try {
            return repository.findClienteByCpf(_cpf);
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }

    public List<Map<String, String>> listaClientePorEmail(String _email){
        try{
            return repository.findClienteByEmail(_email);
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }
}
