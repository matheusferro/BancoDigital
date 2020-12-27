package com.example.BancoDigital.repository.anexo;

import com.example.BancoDigital.model.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository<Anexo, Long> {
}
