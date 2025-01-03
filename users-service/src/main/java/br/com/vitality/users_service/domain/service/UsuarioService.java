package br.com.vitality.users_service.domain.service;

import br.com.vitality.users_service.api.dto.input.*;
import br.com.vitality.users_service.api.dto.output.TreinoOutputDTO;
import br.com.vitality.users_service.api.dto.output.UsuarioOutputDTO;
import br.com.vitality.users_service.api.exception.AssinaturaException;
import br.com.vitality.users_service.api.exception.NotFoundException;
import br.com.vitality.users_service.api.http.TreinoClient;
import br.com.vitality.users_service.domain.model.Usuario;
import br.com.vitality.users_service.domain.repository.UsuarioRepository;
import br.com.vitality.users_service.domain.service.strategy.TreinoInputFactory;
import br.com.vitality.users_service.domain.utils.enums.Assinatura;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;
    private RabbitTemplate rabbitTemplate;
    private TreinoClient treinoClient;
    private TreinoInputFactory treinoInputFactory;

    public ResponseEntity<Void> cadastrar(CadastroUsuarioDTO dto) {
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuario.setAssinatura(Assinatura.GRATUITA);
        usuarioRepository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public Page<UsuarioOutputDTO> listarUsuarios(Pageable paginacao) {
        Page<UsuarioOutputDTO> usuarios = usuarioRepository.findAll(paginacao)
                .map(u -> modelMapper.map(u, UsuarioOutputDTO.class));

        if (usuarios.isEmpty()) throw new NotFoundException("Nenhum usuário encontrado");

        return usuarios;
    }

    public UsuarioOutputDTO listarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        return modelMapper.map(usuario, UsuarioOutputDTO.class);
    }

    @Transactional
    public UsuarioOutputDTO atualizar(AtualizarUsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setAltura(dto.getAltura());
        usuario.setPeso(dto.getPeso());
        usuario.setGenero(dto.getGenero());

        return modelMapper.map(usuario, UsuarioOutputDTO.class);
    }

    public ResponseEntity<Void> deletar(Long id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<Void> fazerPagamento(FazerPagamentoDTO dto) {
        usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        rabbitTemplate.convertAndSend("payment.request.queue", dto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    public void mudarAssinatura(PagamentoOutputDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        usuario.setAssinatura(dto.getAssinatura());
    }

    public ResponseEntity<TreinoOutputDTO> criarTreino(CaloriaDesejadaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        if (!usuario.getAssinatura().equals(Assinatura.PREMIUM_PLUS))
            throw new AssinaturaException("Você precisa da assinatura Premius Plus para acessar esse recurso");

        TreinoInputDTO input = treinoInputFactory.criarTreinoInput(usuario, dto);
        TreinoOutputDTO treinoOutput = treinoClient.criarTreino(input);

        return ResponseEntity.status(HttpStatus.OK).body(treinoOutput);
    }
}
