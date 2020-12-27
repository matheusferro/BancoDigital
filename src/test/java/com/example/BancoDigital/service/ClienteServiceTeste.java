package com.example.BancoDigital.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import com.example.BancoDigital.dto.model.ClienteDTO;
import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.repository.cliente.ClienteRepository;
import com.example.BancoDigital.service.cliente.ClienteService;
import org.junit.jupiter.api.*;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class ClienteServiceTeste {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRepository repository;

    @Test
    @Order(1)
    public void testCadastroCliente() {

//        TODO: BDDMockito.given(repository.save(Mockito.any(Cliente.class)))
//                .willReturn(getMockTransaction());
        ClienteDTO response = service.cadastroCliente(getMockTransaction().convertEntityToDTO());

        assertNotNull(response);
        assertEquals(getMockTransaction().getCpf(), response.getCpf());
    }

    @Test
    @Order(2)
    public void testListaTodosClientes() {
        List<Cliente> response = service.listaTodosClientes();
        assertNotNull(response);
    }

    @Test
    @Order(3)
    public void testListaClientePorCpf() {
        List<Map<String, String>> response = service.listaClientePorCpf(getMockTransaction().getCpf());
        assertNotNull(response);
    }

    @Test
    @Order(4)
    public void testListaClientePorEmail() {
        List<Map<String, String>> response = service.listaClientePorEmail(getMockTransaction().getEmail());
        assertNotNull(response);
    }

    private Cliente getMockTransaction() {

        Cliente cliente = new Cliente("José",
                "Silva",
                "896.814.160-66",
                "josilva@gmail.com",
                "00123456789",
                LocalDate.of(1949,03, 03));
        return cliente;
    }
}
