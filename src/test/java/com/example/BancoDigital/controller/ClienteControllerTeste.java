package com.example.BancoDigital.controller;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.BancoDigital.dto.model.ClienteDTO;
import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.service.cliente.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class ClienteControllerTeste {

    private static final String NOME = "José";
    private static final String SOBRENOME = "Silva";
    private static final String CPF = "203.303.930-73";
    private static final String EMAIL = "josilva01@gmail.com";
    private static final String CNH = "00123456789";
    private static final String DTNASC = "1949-03-03";
    private static final String URL = "/bancoDigital/v1/cliente";

    private HttpHeaders headers;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClienteService service;

    @BeforeAll
    private void setUp() {
        headers = new HttpHeaders();
        headers.set("X-api-key", "key");
    }

    @Test
    @Order(1)
    public void testSave() throws Exception {

        BDDMockito.given(service.cadastroCliente(Mockito.any(ClienteDTO.class))).willReturn(getMockTransaction());

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(NOME, SOBRENOME, CPF, EMAIL, CNH, DTNASC))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .headers(headers))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.nome").value(NOME))
                .andExpect(jsonPath("$.data.sobrenome").value(SOBRENOME))
                .andExpect(jsonPath("$.data.email").value(EMAIL))
                .andExpect(jsonPath("$.data.cpf").value(CPF))
                .andExpect(jsonPath("$.data.cnh").value(CNH))
                .andExpect(jsonPath("$.data.dtNasc").value("1949-03-03"));
    }

    private ClienteDTO getMockTransaction() {

        Cliente cliente = new Cliente(NOME, SOBRENOME, CPF, EMAIL, CNH, LocalDate.of(1949,03, 03));
        return cliente.convertEntityToDTO();
    }

    private String getJsonPayload(String nome, String sobrenome, String cpf, String email, String cnh, String dtNasc) throws JsonProcessingException {

        Cliente dto = new Cliente(nome, sobrenome, cpf, email, cnh, LocalDate.of(1949,03, 03));

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(dto);
    }
}
