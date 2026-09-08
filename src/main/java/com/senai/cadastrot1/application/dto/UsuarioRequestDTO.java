package com.senai.cadastrot1.application.dto;

import com.senai.cadastrot1.domain.entity.Usuario;

import java.util.UUID;

public record UsuarioRequestDTO(
        String nome,
        String cpf,
        String email,
        String senha
) {
    public Usuario toEntity() {
        return new Usuario(
                null,
                nome,
                cpf,
                email,
                senha
        );
    }


}