package br.com.vitality.users_service.api.controller;

import br.com.vitality.users_service.api.dto.input.AtualizarUsuarioDTO;
import br.com.vitality.users_service.api.dto.input.CadastroUsuarioDTO;
import br.com.vitality.users_service.api.dto.input.FazerPagamentoDTO;
import br.com.vitality.users_service.api.dto.input.CaloriaDesejadaDTO;
import br.com.vitality.users_service.api.dto.output.TreinoOutputDTO;
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

    @GetMapping
    public Page<UsuarioOutputDTO> listarUsuarios(@PageableDefault(size = 10) Pageable paginacao) {
        return usuarioService.listarUsuarios(paginacao);
    }

    @GetMapping("/{id}")
    public UsuarioOutputDTO listarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.listarUsuarioPorId(id);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody CadastroUsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }

    @PutMapping
    public UsuarioOutputDTO atualizar(@RequestBody AtualizarUsuarioDTO dto) {
        return usuarioService.atualizar(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return usuarioService.deletar(id);
    }

    @PostMapping("/pagamentos")
    public ResponseEntity<Void> fazerPagamento(@RequestBody FazerPagamentoDTO dto) {
        return usuarioService.fazerPagamento(dto);
    }

    @PostMapping("/treino")
    public ResponseEntity<TreinoOutputDTO> criarTreino(@RequestBody CaloriaDesejadaDTO dto) {
        return usuarioService.criarTreino(dto);
    }
}
