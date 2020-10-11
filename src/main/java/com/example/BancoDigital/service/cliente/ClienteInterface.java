package com.example.BancoDigital.service.cliente;

import com.example.BancoDigital.dto.model.ClienteDTO;
import com.example.BancoDigital.model.Cliente;

import java.util.List;
import java.util.Map;

public interface ClienteInterface {

    ClienteDTO cadastroCliente(ClienteDTO cliente);

    List<Cliente> listaTodosClientes();

    List<Map<String, String>> listaClientePorCpf(String _cpf);

    List<Map<String, String>> listaClientePorEmail(String _email);
}
