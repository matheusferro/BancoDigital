package com.example.BancoDigital.repository.cliente;

import com.example.BancoDigital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mySql")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
