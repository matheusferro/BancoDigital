package com.example.BancoDigital.controller;

import com.example.BancoDigital.model.Endereco;
import com.example.BancoDigital.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bancoDigital/v1/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public void cadastrarEndereco(@RequestBody Endereco _endereco){
        service.cadastrarEndereco(_endereco);
    }

    @GetMapping(path = "{id}")
    public List<Map<String, String>> buscarEnderecoDeCliente(@PathVariable("id") String _id){
        return service.buscarEnderecoPorCliente(_id);
    }
}