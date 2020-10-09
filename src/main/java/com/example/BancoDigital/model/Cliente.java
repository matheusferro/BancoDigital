package com.example.BancoDigital.model;

import com.example.BancoDigital.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

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

    @Column(name = "TB_CLIENTE_EMAIL")
    private String email;

    @Column(name = "TB_CLIENTE_CNH")
    private String cnh;

    @Column(name = "TB_CLIENTE_DT_NASC")
    private String dtNasc;

    public Cliente(String nome, String sobrenome, String email, String cnh, String dtNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cnh = cnh;
        this.dtNasc = dtNasc;
    }

    public ClienteDTO convertEntityToDTO(){
        return new ModelMapper().map(this, ClienteDTO.class);
    }
}
