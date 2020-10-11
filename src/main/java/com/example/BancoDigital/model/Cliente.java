package com.example.BancoDigital.model;

import com.example.BancoDigital.dto.model.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class Cliente {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tbClienteId;

    @Column(name = "TB_CLIENTE_NOME")
    private String nome;

    @Column(name = "TB_CLIENTE_SOBRENOME")
    private String sobrenome;

    @Column(name = "TB_CLIENTE_CPF")
    private String cpf;

    @Column(name = "TB_CLIENTE_EMAIL")
    private String email;

    @Column(name = "TB_CLIENTE_CNH")
    private String cnh;

    @Column(name = "TB_CLIENTE_DT_NASC")
    @DateTimeFormat(pattern="YYYY-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dtNasc;

    public Cliente(String nome, String sobrenome, String cpf, String email, String cnh, LocalDate dtNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.cnh = cnh;
        this.dtNasc = dtNasc;
    }

    public ClienteDTO convertEntityToDTO(){
        return new ModelMapper().map(this, ClienteDTO.class);
    }
}
