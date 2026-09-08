package com.senai.cadastrot1.application.service;

import com.senai.cadastrot1.application.dto.UsuarioRequestDTO;
import com.senai.cadastrot1.domain.entity.Usuario;
import com.senai.cadastrot1.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if(usuarioOpt.isPresent()) {
            return  usuarioOpt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario save(UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioRepository.save(
                usuarioRequestDTO.toEntity()
        );
    }

    public Usuario update(UsuarioRequestDTO usuarioRequestDTO, UUID id) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuarioRequestDTO.nome());
        usuarioExistente.setCpf(usuarioRequestDTO.cpf());
        usuarioExistente.setEmail(usuarioRequestDTO.email());
        usuarioExistente.setSenha(usuarioRequestDTO.senha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void delete(UUID id) {
        usuarioRepository.delete(findById(id));
    }
}
