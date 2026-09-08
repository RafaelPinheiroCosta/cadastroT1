package com.senai.cadastrot1.domain.repository;


import com.senai.cadastrot1.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);

    Boolean existsByCpf(String cpf);
}
