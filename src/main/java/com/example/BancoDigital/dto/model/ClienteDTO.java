package com.example.BancoDigital.dto.model;

import com.example.BancoDigital.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends RepresentationModel<ClienteDTO> {

    private Long id;

    @NotNull
    @NotBlank(message="NOME INVÁLIDO.")
    private String nome;

    @NotNull
    @NotBlank(message="SOBRENOME INVÁLIDO.")
    private String sobrenome;

    @NotNull
    @NotBlank(message="CPF INVÁLIDO.")
    @CPF(message = "CPF INVÁLIDO.")
    private String cpf;

    @NotNull
    @NotBlank(message="EMAIL INVÁLIDO.")
    @Email(message="EMAIL INVÁLIDO.")
    private String email;

    @NotNull
    @Length(min=11, message="CNH DEVE CONTER 11 DIGITOS.")
    @NotBlank(message="CNH INVÁLIDA.")
    private String cnh;

    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate dtNasc;

    public Cliente convertDTOToEntity(){
        return new ModelMapper().map(this, Cliente.class);
    }
}
