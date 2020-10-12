package com.example.BancoDigital.controller;

import com.example.BancoDigital.Utils.Validacao;
import com.example.BancoDigital.dto.model.EnderecoDTO;
import com.example.BancoDigital.dto.response.Response;
import com.example.BancoDigital.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bancoDigital/v1/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @PostMapping
    public ResponseEntity<Response<EnderecoDTO>> cadastrarEndereco(@Valid @RequestBody EnderecoDTO _enderecodto, BindingResult errors){
        Response<EnderecoDTO> response = new Response<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        _enderecodto = service.cadastrarEndereco(_enderecodto);
        response.setData(_enderecodto);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.LOCATION, "link");
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public List<Map<String, String>> buscarEnderecoDeCliente(@PathVariable("id") String _id){
        return service.buscarEnderecoPorCliente(_id);
    }
}