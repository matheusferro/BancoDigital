package com.example.BancoDigital.dto.model;

import com.example.BancoDigital.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO extends RepresentationModel<EnderecoDTO> {
    @NotNull
    private Long tbEnderecoId;

    @NotNull
    private Long clienteId;

    @NotNull
    @NotBlank(message="CEP INVÁLIDO.")
    @Pattern(regexp  = "\\d{5}-\\d{3}", message = "CEP NÃO ESTÁ NO FORMATO CORRETO.")
    private String cep;

    @NotNull
    @NotBlank(message="RUA INVÁLIDO.")
    private String rua;

    @NotNull
    @NotBlank(message="BAIRRO INVÁLIDO.")
    private String bairro;

    @NotNull
    @NotBlank(message="COMPLEMENTO INVÁLIDO.")
    private String complemento;

    @NotNull
    @NotBlank(message="CIDADE INVÁLIDO.")
    private String cidade;

    @NotNull
    @NotBlank(message="ESTADO INVÁLIDO.")
    private String estado;

    public Endereco convertDTOToEntity(){ return new ModelMapper().map(this, Endereco.class);}

}