package br.com.vitality.users_service.domain.service;

import br.com.vitality.users_service.api.dto.input.CadastroUsuarioDTO;
import br.com.vitality.users_service.api.dto.output.UsuarioOutputDTO;
import br.com.vitality.users_service.api.exception.NotFoundException;
import br.com.vitality.users_service.domain.model.Usuario;
import br.com.vitality.users_service.domain.repository.UsuarioRepository;
import br.com.vitality.users_service.domain.utils.enums.Assinatura;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;

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
}
