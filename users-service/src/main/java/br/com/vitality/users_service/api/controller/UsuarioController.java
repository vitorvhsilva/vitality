package br.com.vitality.users_service.api.controller;

import br.com.vitality.users_service.api.dto.input.CadastroUsuarioDTO;
import br.com.vitality.users_service.api.dto.output.UsuarioOutputDTO;
import br.com.vitality.users_service.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody CadastroUsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @GetMapping
    public Page<UsuarioOutputDTO> listarUsuarios(@PageableDefault(size = 10) Pageable paginacao) {
        return usuarioService.listarUsuarios(paginacao);
    }
}
