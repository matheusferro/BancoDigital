package com.example.BancoDigital.dto;

import com.example.BancoDigital.model.Cliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;


@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends RepresentationModel<ClienteDTO> {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private String email;

    @NotNull
    @Length(min=11, message="CNH DEVE CONTER 11 DIGITOS")
    private String cnh;

    @NotNull
    private String dtNasc;

    public Cliente convertDTOToEntity(){
        return new ModelMapper().map(this, Cliente.class);
    }
}
