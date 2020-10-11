package com.example.BancoDigital.factory.cliente;

import com.example.BancoDigital.model.Cliente;

import java.util.List;

public interface ClienteDAO {

    int save(Cliente cliente);

    List<Cliente> findAll();

}
