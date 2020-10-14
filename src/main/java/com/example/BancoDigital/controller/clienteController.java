package com.example.BancoDigital.controller;

import com.example.BancoDigital.Utils.Validacao;
import com.example.BancoDigital.dto.model.ClienteDTO;
import com.example.BancoDigital.dto.response.Response;
import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.service.cliente.ClienteService;
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

@RestController
@RequestMapping("/bancoDigital/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Response<ClienteDTO>> cadastroCliente( @Valid @RequestBody ClienteDTO _clientedto, BindingResult errors){
        Response<ClienteDTO> response = new Response<>();

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        _clientedto = clienteService.cadastroCliente(_clientedto);
//        response.setData(_clientedto);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.LOCATION, "/bancoDigital/v1/endereco");
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }

}
