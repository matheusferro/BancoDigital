package com.example.BancoDigital.service.cliente;

import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {
//
//    private final ClienteDAO clienteDAO;
//
//    @Autowired
//    public ClienteService(@Qualifier("mySql") ClienteDAO clienteDAO) {
//        this.clienteDAO = clienteDAO;
//    }
    @Autowired
    private ClienteRepository repository;

    public Cliente cadastroCliente(Cliente _cliente){
        return repository.save(_cliente);
    }

    public List<Cliente> listaTodosClientes(){

        return repository.findAll();
    }


}
