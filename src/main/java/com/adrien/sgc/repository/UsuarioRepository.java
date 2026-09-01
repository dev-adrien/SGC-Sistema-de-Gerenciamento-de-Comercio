package com.adrien.sgc.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adrien.sgc.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}