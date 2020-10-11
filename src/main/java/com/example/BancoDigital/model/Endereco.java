package com.example.BancoDigital.model;

import com.example.BancoDigital.dto.model.EnderecoDTO;
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
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tbEnderecoId;

    @Column(name="TB_CLIENTE_ID")
    private Long clienteId;

    @Column(name = "TB_ENDERECO_CEP")
    private String cep;

    @Column(name = "TB_ENDERECO_RUA")
    private String rua;

    @Column(name = "TB_ENDERECO_BAIRRO")
    private String bairro;

    @Column(name = "TB_ENDERECO_COMPLEMENTO")
    private String complemento;

    @Column(name = "TB_ENDERECO_CIDADE")
    private String cidade;

    @Column(name = "TB_ENDERECO_ESTADO")
    private String estado;

    public EnderecoDTO convertEntityToDTO(){ return new ModelMapper().map(this, EnderecoDTO.class);}

}