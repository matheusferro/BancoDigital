package com.example.BancoDigital.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.BancoDigital.model.Cliente;
import com.example.BancoDigital.repository.cliente.ClienteRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class ClienteRepositoryTeste {

    @Autowired
    private ClienteRepository repository;

    @BeforeAll
    private void setUp(){
        Cliente cliente = new Cliente("José",
                                    "Silva",
                                    "123.123.123-00",
                                    "josilva@gmail.com",
                                    "00123456789",
                                    LocalDate.of(1949,03, 03));

        repository.save(cliente);
    }

    @Test
    @Order(1)
    public void testSave() {

        Cliente cliente = new Cliente("José",
                "Silva",
                "123.123.123-00",
                "josilva@gmail.com",
                "00123456789",
                LocalDate.of(1949,03, 03));
        Cliente response = repository.save(cliente);

        assertNotNull(response);
    }

    @Test
    @Order(2)
    public void testFindByCpf() {
        List<Map<String, String>> response = repository.findClienteByCpf("123.123.123-00");
        assertNotNull(response);
    }


    @Test
    @Order(3)
    public void testFindByEmail() {

        List<Map<String, String>> response = repository.findClienteByEmail("josilva@gmail.com");

        assertNotNull(response);
    }

    @AfterAll
    private void tearDown() {
        repository.deleteAll();
    }
}
