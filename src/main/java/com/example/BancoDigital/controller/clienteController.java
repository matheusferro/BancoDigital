package com.example.BancoDigital.controller;

import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancoDigital/v1/cliente")
public class clienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void cadastroCliente(@RequestBody Cliente _cliente){
        clienteService.cadastroCliente(_cliente);
    }

    @GetMapping
    public List<Cliente> listaCliente(){
        return clienteService.listaTodosClientes();
    }
}
