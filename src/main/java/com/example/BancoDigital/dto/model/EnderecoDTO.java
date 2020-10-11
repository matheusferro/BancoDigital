package com.example.BancoDigital.dto.model;

import com.example.BancoDigital.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

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
    private String cep;

    @NotNull
    private String rua;

    @NotNull
    private String bairro;

    @NotNull
    private String complemento;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    public Endereco convertDTOToEntity(){ return new ModelMapper().map(this, Endereco.class);}

}