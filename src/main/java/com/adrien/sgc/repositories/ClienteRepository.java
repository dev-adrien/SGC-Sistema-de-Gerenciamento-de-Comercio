package com.adrien.sgc.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpfCnpj(String cpfCnpj);
    boolean existsByCpfCnpj(String cpfCnpj);
}