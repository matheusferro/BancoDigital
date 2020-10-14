package com.example.BancoDigital.controller;

import com.example.BancoDigital.dto.model.AnexoDTO;
import com.example.BancoDigital.dto.response.Response;
import com.example.BancoDigital.service.anexo.AnexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("bancoDigital/v1/anexo")
public class AnexoController {

    @Autowired
    AnexoService service;

    @PostMapping()
    public ResponseEntity<Response<AnexoDTO>> uploadFile(@RequestHeader("tbClienteId") String _tbClienteId, @Valid @RequestParam("file") MultipartFile file) {
        Response<AnexoDTO> response = new Response<>();
        service.uploadArquivo(_tbClienteId, file);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.LOCATION, "link");
        return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
    }

}
