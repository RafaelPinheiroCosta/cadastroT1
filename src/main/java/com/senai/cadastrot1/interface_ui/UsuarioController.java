package com.senai.cadastrot1.interface_ui;

import com.senai.cadastrot1.application.dto.UsuarioRequestDTO;
import com.senai.cadastrot1.application.dto.UsuarioResponseDTO;
import com.senai.cadastrot1.application.service.UsuarioService;
import com.senai.cadastrot1.domain.entity.Usuario;
import com.senai.cadastrot1.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarUsuarioPorId(@PathVariable UUID id) {
       return usuarioService.findById(id);
    }

    @PostMapping
    public UsuarioResponseDTO cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.save(usuarioRequestDTO);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable UUID id,
                                    @Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioService.update(usuarioRequestDTO,id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}
