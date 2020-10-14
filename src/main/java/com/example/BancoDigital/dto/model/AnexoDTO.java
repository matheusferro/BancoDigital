package com.example.BancoDigital.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class AnexoDTO extends RepresentationModel<AnexoDTO> {

    private Long tbArquivoId;

    @NotNull
    @NotBlank(message="ARQUIVO INVÁLIDO.")
    private String file;

    @NotNull
    private String tbClienteId;
}
